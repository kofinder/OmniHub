package com.finderbar.omnihub.modules.iam.ui.builder

import com.finderbar.omnihub.core.ui.builder.PageModelBuilder
import com.finderbar.omnihub.modules.iam.ui.model.PageViewModel
import com.finderbar.omnihub.modules.iam.ui.page.LoginPage
import org.springframework.stereotype.Component

@Component
class AuthPageModelBuilder : PageModelBuilder<LoginPage> {
    override fun build(page: LoginPage): Map<String, Any> {
        val vm = PageViewModel(
            appName = page.context.appName,
            pageTitle = page.pageTitle,
            pageDescription = "Login to system",
            authorName = "Ko Thein",
            locale = page.context.locale,
            bodyClass = "cs-auth-page",
        )
        return mapOf(
            "page" to vm
        )
    }
}