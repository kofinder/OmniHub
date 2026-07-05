package com.finderbar.omnihub.modules.iam.ui.login

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.auth.AuthConfig
import com.finderbar.omnihub.core.ui.layout.auth.AuthModel
import com.finderbar.omnihub.core.ui.usecase.UseCase


class LoginUseCase(
    model: AuthModel,
    config: AuthConfig,
    context: AppContext
) : UseCase<AuthModel, AuthConfig, AppContext>(
    model,
    config,
    context
) {

    fun login(username: String, password: String) {

        // start loading
        model.isLoading = true
        model.errorMessage = null

        // simulate validation
        if (username.isBlank() || password.isBlank()) {
            model.isLoading = false
            model.errorMessage = "Username or password cannot be empty"
            return
        }

        // fake success rule
        if (username == "admin" && password == "1234") {
            model.isLoading = false
            model.isLoggedIn = true
        } else {
            model.isLoading = false
            model.errorMessage = "Invalid credentials"
        }
    }

    fun resetError() {
        model.errorMessage = null
    }

    fun logout() {
        model.isLoggedIn = false
    }
}