package com.finderbar.omnihub.modules.iam.services


import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.modules.iam.command.AuthLoginCommand
import com.finderbar.omnihub.modules.iam.model.LoginModel
import com.finderbar.omnihub.modules.iam.repository.RoleRepository
import com.finderbar.omnihub.modules.iam.repository.UserRepository
import com.finderbar.omnihub.security.JwtTokenManager
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val jwtTokenManager: JwtTokenManager,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
    private val passwordEncoder: PasswordEncoder,
    private val refreshTokenService: RefreshTokenService,
    private val authenticationManager: AuthenticationManager
) {

    @Transactional(readOnly = true)
    fun login(request: AuthLoginCommand): ApiResponse<LoginModel> {
        authenticationManager.authenticate(
            UsernamePasswordAuthenticationToken(
                request.username,
                request.password
            )
        )

        val user = userRepository.findByUsername(
            request.username
        ) ?: throw IllegalArgumentException("User not found")

        val accessToken = jwtTokenManager.generateToken(request.username, user.id.toString())
        val refreshToken = refreshTokenService.create(user)

        return ApiResponse(
            success = true,
            message = "Login successful",
            result = LoginModel( user.id.toString(), user.username,accessToken, refreshToken.token)
        )
    }
}
