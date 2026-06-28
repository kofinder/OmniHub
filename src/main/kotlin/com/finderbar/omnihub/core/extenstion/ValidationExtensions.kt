package com.finderbar.omnihub.core.extenstion

fun requireNotBlank(
    value: String?,
    message: String
): String =
    value
        ?.trim()
        ?.takeIf(String::isNotEmpty)
        ?: throw IllegalArgumentException(message)