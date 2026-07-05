package com.finderbar.omnihub.config.ui

import org.springframework.stereotype.Component

@Component
class TemplateRenderer(
    private val freemarker: freemarker.template.Configuration
) {

    fun render(templatePath: String, model: Map<String, Any>): String {

        val template = freemarker.getTemplate(templatePath)

        val writer = java.io.StringWriter()
        template.process(model, writer)

        return writer.toString()
    }
}