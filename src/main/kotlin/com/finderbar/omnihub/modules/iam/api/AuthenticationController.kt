package com.finderbar.omnihub.modules.iam.api

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.modules.iam.command.AuthLoginCommand
import com.finderbar.omnihub.modules.iam.command.AuthRegisterCommand
import com.finderbar.omnihub.modules.iam.model.LoginModel
import com.finderbar.omnihub.modules.iam.services.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthenticationController(private val authService: AuthenticationService) {

    @PostMapping("/login")
    fun login(@RequestBody request: AuthLoginCommand): ApiResponse<LoginModel> {
        return authService.login(request)
    }

    @PostMapping("/register")
    fun register(@RequestBody request: AuthRegisterCommand): ApiResponse<LoginModel> {
       return authService.register(request);
    }
}