package com.finderbar.omnihub.core.extenstion
import java.time.LocalDate
import java.time.format.DateTimeFormatter

private val DEFAULT_DATE_FORMATTER =
    DateTimeFormatter.ofPattern("yyyy-MM-dd")

fun LocalDate.toValue(): String =
    format(DEFAULT_DATE_FORMATTER)

fun String.toLocalDate(): LocalDate =
    LocalDate.parse(this, DEFAULT_DATE_FORMATTER)