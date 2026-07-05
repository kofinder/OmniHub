package com.finderbar.omnihub.core.ui.render

import com.finderbar.omnihub.config.ui.TemplateRenderer
import com.finderbar.omnihub.core.ui.builder.PageModelBuilder
import com.finderbar.omnihub.core.ui.page.Page
import org.springframework.stereotype.Component

@Component
class PageRenderer(private val tmpRender: TemplateRenderer) {

    fun <P : Page<*, *, *>> render(
        page: P,
        modelBuilder: PageModelBuilder<P>
    ): String {

        val model = modelBuilder.build(page)

        return tmpRender.render(
            page.templatePath,
            model
        )
    }
}