package com.finderbar.omnihub.ui.component.button

data class ButtonConfig(
    val label: String,
    val type: ButtonType = ButtonType.BUTTON,
    val style: ButtonStyle = ButtonStyle.PRIMARY,
    val size: ButtonSize = ButtonSize.MEDIUM,
    val outline: Boolean = false,
    val disabled: Boolean = false,
    val block: Boolean = false,
    val icon: String? = null,
    val id: String? = null,
    val name: String? = null,
    val value: String? = null,
    val cssClass: String? = null,
    val onClick: String? = null
)