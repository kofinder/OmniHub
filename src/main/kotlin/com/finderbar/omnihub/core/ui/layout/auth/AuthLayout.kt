package com.finderbar.omnihub.core.ui.layout.auth

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.Layout

class AuthLayout(
    model: AuthModel,
    config: AuthConfig,
    context: AppContext,
) : Layout<AuthModel, AuthConfig, AppContext>(
    model,
    config,
    context
) {


    override val layoutName: String = "AuthLayout"

    override val templatePath: String = "layout/auth.ftl"

    fun canShowSignup(): Boolean = config.allowSignup

    fun isGuestEnabled(): Boolean = config.allowGuestLogin
}