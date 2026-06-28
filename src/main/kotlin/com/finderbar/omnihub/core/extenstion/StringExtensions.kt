package com.finderbar.omnihub.core.extenstion

@JvmName("cleanNonNull")
fun String.clean(): String =
    trim()

@JvmName("cleanNullable")
fun String?.clean(): String? =
    this
        ?.trim()
        ?.takeIf(String::isNotEmpty)

fun String?.isNotNullOrBlank(): Boolean =
    !this.isNullOrBlank()

fun String?.isNullOrEmptyAfterTrim(): Boolean =
    this?.trim().isNullOrEmpty()


fun String?.cleanOrNull(): String? =
    this
        ?.trim()
        ?.takeIf { it.isNotEmpty() }