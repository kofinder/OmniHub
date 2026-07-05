package com.finderbar.omnihub.modules.iam.ui.page

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.auth.AuthConfig
import com.finderbar.omnihub.core.ui.layout.auth.AuthLayout
import com.finderbar.omnihub.core.ui.layout.auth.AuthModel
import com.finderbar.omnihub.core.ui.page.Page

class LoginPage(
    model: AuthModel,
    config: AuthConfig,
    context: AppContext,
) : Page<AuthModel, AuthConfig, AppContext>(
    model,
    config,
    context
) {
    override val templatePath: String = "pages/login.ftl"

    override val layout: AuthLayout = AuthLayout(model, config, context)

    override val pageTitle: String = "Login"
}