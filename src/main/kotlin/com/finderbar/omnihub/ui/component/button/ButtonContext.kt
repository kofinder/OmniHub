package com.finderbar.omnihub.ui.component.button


data class ButtonContext(
    val locale: String = "en",
    val permissions: Set<String> = emptySet(),
    val requestId: String? = null
)