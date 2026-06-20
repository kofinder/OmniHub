package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.modules.iam.command.AuthLoginCommand
import com.finderbar.omnihub.modules.iam.model.LoginModel
import com.finderbar.omnihub.modules.iam.repository.UserAccountRepository
import com.finderbar.omnihub.modules.iam.services.RefreshTokenService
import com.finderbar.omnihub.modules.utility.SecurityEventType
import com.finderbar.omnihub.security.model.ApplicationUserPrincipal
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID


@Service
class AuthenticationService(
    private val jwtTokenService: JwtTokenService,
    private val userRepository: UserAccountRepository,
    private val refreshService: RefreshTokenService,
    private val securityAuditService: SecurityAuditService,
    private val deviceFingerprintService: DeviceFingerprintService,
    private val anomalyService: LoginAnomalyService,
    private val rateLimitService: LoginRateLimitService,
    private val geoIpService: GeoIpService,
    private val authenticationManager: AuthenticationManager
) {

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
            val accessToken = jwtTokenService.generateToken(principal)

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

        val accessToken = jwtTokenService.generateToken(principal)

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