package com.finderbar.omnihub.core.ui.layout.auth

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.Layout

class AuthLayout(
    model: AuthModel,
    config: AuthConfig,
    context: AppContext,
    override val templatePath: String
) : Layout<AuthModel, AuthConfig, AppContext>(
    model,
    config,
    context
) {

    override val layoutName: String = "AuthLayout"

    fun render(): String {
        return when {
            model.isLoading -> "Loading login screen..."
            model.isLoggedIn -> "Redirecting..."
            model.errorMessage != null -> "Error: ${model.errorMessage}"
            else -> "Render login form"
        }
    }

    fun canShowSignup(): Boolean = config.allowSignup

    fun isGuestEnabled(): Boolean = config.allowGuestLogin
}