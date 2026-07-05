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
import org.springframework.web.bind.annotation.ResponseBody


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
        return "redirect:/login"
    }


    @GetMapping("/login")
    @ResponseBody
    fun loginPage(): String {
        val page = LoginPage(model, config, context)
        return pageRenderer.render(page, builder)
    }

    @PostMapping("/login")
    @ResponseBody
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
    @ResponseBody
    fun logout(): String {

        loginUseCase.logout()

        val page = LoginPage(model, config, context)

        return pageRenderer.render(page, builder)
    }
}