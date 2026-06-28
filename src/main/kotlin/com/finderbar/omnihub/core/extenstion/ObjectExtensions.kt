package com.finderbar.omnihub.core.extenstion


fun <T> T?.requireNotNull(
    lazyMessage: () -> String
): T =
    this ?: throw IllegalArgumentException(lazyMessage())