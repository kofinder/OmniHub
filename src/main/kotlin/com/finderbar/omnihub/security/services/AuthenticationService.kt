package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.modules.core.repository.EmployeeRepository
import com.finderbar.omnihub.modules.iam.command.AuthLoginCommand
import com.finderbar.omnihub.modules.iam.command.AuthRegisterCommand
import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import com.finderbar.omnihub.modules.iam.entity.UserRoleEntity
import com.finderbar.omnihub.modules.iam.model.LoginModel
import com.finderbar.omnihub.modules.iam.repository.RoleRepository
import com.finderbar.omnihub.modules.iam.repository.UserAccountRepository
import com.finderbar.omnihub.modules.iam.services.RefreshTokenService
import com.finderbar.omnihub.modules.utility.SecurityEventType
import com.finderbar.omnihub.security.model.ApplicationUserPrincipal
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID


@Service
class AuthenticationService(
    private val jwtTokenService: JwtTokenService,
    private val userRepository: UserAccountRepository,
    private val employeeRepository: EmployeeRepository,
    private val refreshService: RefreshTokenService,
    private val securityAuditService: SecurityAuditService,
    private val deviceFingerprintService: DeviceFingerprintService,
    private val anomalyService: LoginAnomalyService,
    private val rateLimitService: LoginRateLimitService,
    private val geoIpService: GeoIpService,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,
    private val authenticationManager: AuthenticationManager
) {

    fun register(request: AuthRegisterCommand): ApiResponse<String> {

        require(request.username.isNotBlank()) { "Username is required" }
        require(request.password.isNotBlank()) { "Password is required" }
        require(request.employeeId.isNotBlank()) { "Employee is required" }

        val employee = employeeRepository.findById(UUID.fromString(request.employeeId))
            .orElseThrow { IllegalArgumentException("Employee is not found") }

        // ✅ IMPORTANT: enforce 1 employee = 1 user
        if (userRepository.existsByEmployeeId(employee.id!!)) {
            throw IllegalArgumentException("Employee already has a user account")
        }

        if (userRepository.existsByUsername(request.username)) {
            throw IllegalArgumentException("Username already exists")
        }

        val defaultRole = roleRepository.findByCode("STAFF")
            ?: throw IllegalStateException("Default role STAFF not found")

        val user = UserAccountEntity(
            employee = employee,
            username = request.username.trim(),
            passwordHash = passwordEncoder.encode(request.password)!!,
            enabled = true
        )

        user.userRoles.add(
            UserRoleEntity(
                user = user,
                role = defaultRole
            )
        )

        userRepository.save(user)

        return ApiResponse.ok("User registered successfully")
    }

    @Transactional
    fun login(
        command: AuthLoginCommand,
        request: HttpServletRequest
    ): ApiResponse<LoginModel> {

        val username = command.username

        // 1. RATE LIMIT CHECK
        if (rateLimitService.isBlocked(username)) {
            throw RuntimeException("Too many login attempts. Try again later.")
        }

        val device = deviceFingerprintService.generate(request)
        val ip = device.ip
        val country = geoIpService.getCountry(ip)

        try {

            // 2. AUTHENTICATE
            val auth = authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(username, command.password)
            )

            val principal = auth.principal as UserDetails

            val userEntity = userRepository.findByUsername(username)
                ?: throw RuntimeException("User not found")

            // 3. ANOMALY DETECTION (NOW SAFE)
            val suspicious = anomalyService.isSuspicious(
                userEntity.id!!,
                device.deviceHash
            )

            if (suspicious) {
                securityAuditService.log(
                    username = username,
                    eventType = SecurityEventType.LOGIN_SUSPICIOUS,
                    success = true,
                    ip = ip,
                    details = "New device login detected"
                )
            }

            // 4. GENERATE TOKENS
            val accessToken = jwtTokenService.generateToken(userEntity)

            val refreshToken = refreshService.create(
                user = userEntity,
                sessionId = UUID.randomUUID().toString(),
                ip = ip
            )

            // 5. RESET RATE LIMIT (SUCCESS LOGIN)
            rateLimitService.reset(username)

            // 6. AUDIT SUCCESS
            securityAuditService.log(
                username = username,
                eventType = SecurityEventType.LOGIN_SUCCESS,
                success = true,
                ip = ip,
                details = "Country=$country, Device=${device.deviceHash}"
            )

            return ApiResponse(
                success = true,
                message = "Login successful",
                result = LoginModel(
                    userEntity.id.toString(),
                    principal.username,
                    accessToken,
                    refreshToken.token
                )
            )

        } catch (ex: Exception) {

            // 7. RATE LIMIT FAILURE TRACKING
            rateLimitService.recordFailure(username)

            securityAuditService.log(
                username = username,
                eventType = SecurityEventType.LOGIN_FAILED,
                success = false,
                ip = ip,
                details = ex.message
            )

            throw ex
        }
    }

    // =========================================
    // REFRESH TOKEN FLOW
    // =========================================
    @Transactional
    fun refresh(refreshToken: String): ApiResponse<LoginModel> {

        val stored = refreshService.validate(refreshToken)

        val user = stored.user

        // mark old token as used (rotation security)
        refreshService.markUsed(stored)

        val principal = ApplicationUserPrincipal(
            user.id.toString(),
            user.username,
            user.passwordHash,
            emptyList()
        )

        val accessToken = jwtTokenService.generateToken(user)

        val newRefresh = refreshService.create(
            user = user,
            sessionId = stored.sessionId,
            ip = stored.ipAddress
        )

        securityAuditService.log(
            username = user.username,
            eventType = SecurityEventType.TOKEN_REFRESH,
            success = true,
            ip = stored.ipAddress,
            details = "Token rotated"
        )

        return ApiResponse(
            success = true,
            message = "Token refreshed",
            result = LoginModel(
                user.id.toString(),
                user.username,
                accessToken,
                newRefresh.token
            )
        )
    }

    // =========================================
    // LOGOUT FLOW
    // =========================================
    @Transactional
    fun logout(refreshToken: String) {

        val token = refreshService.validate(refreshToken)

        refreshService.revoke(token)

        securityAuditService.log(
            username = token.user.username,
            eventType = SecurityEventType.LOGOUT,
            success = true,
            ip = token.ipAddress,
            details = "User logged out"
        )
    }


}