package com.finderbar.omnihub.core.extenstion

import java.util.UUID

@JvmName("toValueNonNull")
fun UUID.toValue(): String = toString()

@JvmName("toValueNullable")
fun UUID?.toValue(): String? = this?.toString()

fun String.toUuid(): UUID =
    UUID.fromString(trim())

@JvmName("toUuidOrNullNonNullable")
fun String.toUuidOrNull(): UUID? =
    runCatching {
        UUID.fromString(trim())
    }.getOrNull()

@JvmName("toUuidOrNullNullable")
fun String?.toUuidOrNull(): UUID? =
    this
        ?.trim()
        ?.takeIf(String::isNotEmpty)
        ?.let(UUID::fromString)

