package com.finderbar.omnihub.modules.iam.ui.controller

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.auth.AuthConfig
import com.finderbar.omnihub.core.ui.layout.auth.AuthModel
import com.finderbar.omnihub.core.ui.render.PageRenderer
import com.finderbar.omnihub.modules.iam.ui.builder.AuthPageModelBuilder
import com.finderbar.omnihub.modules.iam.ui.page.LoginPage
import com.finderbar.omnihub.modules.iam.ui.usecase.LoginUseCase
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
class LoginController(
    private val pageRenderer: PageRenderer,
    private val builder: AuthPageModelBuilder
) {
    private val model = AuthModel()
    private val config = AuthConfig()
    private val context = AppContext()

    private val loginUseCase = LoginUseCase(
        model,
        config,
        context
    )

    @GetMapping("/")
    fun indexPage(): String {
        return "layout/auth.ftl"
    }


    @GetMapping("/login")
    fun loginPage(): String {
        val page = LoginPage(model, config, context)
        return pageRenderer.render(page, builder)
    }

    @PostMapping("/login")
    fun login(
        @RequestParam username: String,
        @RequestParam password: String
    ): String {

        // 👇 THIS is where UseCase is used
        loginUseCase.login(username, password)

        val page = LoginPage(model, config, context)

        return pageRenderer.render(page, builder)
    }

    @PostMapping("/logout")
    fun logout(): String {

        loginUseCase.logout()

        val page = LoginPage(model, config, context)

        return pageRenderer.render(page, builder)
    }
}