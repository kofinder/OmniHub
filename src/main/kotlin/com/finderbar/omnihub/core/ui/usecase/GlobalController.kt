package com.finderbar.omnihub.core.ui.usecase

import com.finderbar.omnihub.core.ui.page.PageModel
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute

@Controller
class GlobalController {

    @GetMapping("/login")
    fun login(
        @ModelAttribute("page") page: PageModel
    ): String {
        page.pageTitle = "Login"
        return "auth/login"
    }
}