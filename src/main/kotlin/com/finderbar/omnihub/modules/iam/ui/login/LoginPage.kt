package com.finderbar.omnihub.modules.iam.ui.login

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

    override val layout: AuthLayout = AuthLayout()

    override val templatePath: String = ""

    override val pageTitle: String = "Login"

    fun submit() {
        // later: controller or viewmodel
    }

    fun goToSignup() {
        // navigation trigger
    }

    fun renderPage(): String {
        return """
            Page: $pageTitle
            App: ${context.appName}
            Layout: ${layout.layoutName}
            UI: ${layout.render()}
        """.trimIndent()
    }
}
