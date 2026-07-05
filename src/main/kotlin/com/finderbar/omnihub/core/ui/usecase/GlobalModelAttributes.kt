package com.finderbar.omnihub.core.ui.usecase

import com.finderbar.omnihub.core.ui.page.PageModel
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ModelAttribute

@ControllerAdvice
class GlobalModelAttributes {

    @ModelAttribute("page")
    fun page() = PageModel()

}