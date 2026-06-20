package com.finderbar.omnihub.modules.iam.api

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.modules.iam.command.AuthLoginCommand
import com.finderbar.omnihub.modules.iam.command.RefreshTokenCommand
import com.finderbar.omnihub.modules.iam.model.LoginModel
import com.finderbar.omnihub.security.services.AuthenticationService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthenticationController(private val authService: AuthenticationService) {

    @PostMapping("/login")
    fun login(@RequestBody command: AuthLoginCommand, request: HttpServletRequest): ApiResponse<LoginModel> {
        return authService.login(command, request)
    }

    @PostMapping("/refresh")
    fun refresh(
        @RequestBody request: RefreshTokenCommand
    ): ApiResponse<LoginModel> {
        return authService.refresh(request.refreshToken)
    }

    @PostMapping("/logout")
    fun logout(
        @RequestBody request: RefreshTokenCommand
    ): ApiResponse<String> {
        authService.logout(request.refreshToken)
        return ApiResponse(
                success = true,
                message = "Logout successful",
                result = "OK"
        )
    }
}