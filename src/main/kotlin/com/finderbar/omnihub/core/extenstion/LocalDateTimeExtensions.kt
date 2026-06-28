package com.finderbar.omnihub.core.extenstion


import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private val DEFAULT_DATE_TIME_FORMATTER =
    DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

fun LocalDateTime.toValue(): String =
    format(DEFAULT_DATE_TIME_FORMATTER)

fun String.toLocalDateTime(): LocalDateTime =
    LocalDateTime.parse(
        this,
        DEFAULT_DATE_TIME_FORMATTER
    )