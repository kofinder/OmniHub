package com.finderbar.omnihub.core.ui.component.button

import com.finderbar.omnihub.core.ui.component.Component

class ButtonComponent(
    override val model: Unit = Unit,
    override val config: ButtonConfig,
    override val context: ButtonContext = ButtonContext()
) : Component<Unit, ButtonConfig, ButtonContext>(
    model,
    config,
    context
) {

    override val templatePath: String = "component/button/button.ftl"

    override fun renderId(): String {
        return config.id ?: "btn-${config.label.lowercase().replace(" ", "-")}"
    }

    fun cssClasses(): String {
        val classes = mutableListOf("cs-btn")

        classes += if (config.outline) {
            config.style.cssClass.replace("cs-btn", "cs-btn-outline")
        } else {
            config.style.cssClass
        }

        if (config.size.cssClass.isNotBlank()) {
            classes += config.size.cssClass
        }

        if (config.block) {
            classes += "cs-btn-block"
        }

        config.cssClass?.let { classes += it }

        return classes.joinToString(" ")
    }
}
