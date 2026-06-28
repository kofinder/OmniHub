package com.finderbar.omnihub.core.extenstion


import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

fun Instant.toLocalDateTime(
    zoneId: ZoneId = ZoneOffset.UTC
): LocalDateTime =
    LocalDateTime.ofInstant(this, zoneId)

fun LocalDateTime.toInstant(
    zoneId: ZoneId = ZoneOffset.UTC
): Instant =
    atZone(zoneId).toInstant()

fun Instant.toEpochMillis(): Long =
    toEpochMilli()

fun Long.toInstant(): Instant =
    Instant.ofEpochMilli(this)

fun Instant.toIsoString(): String =
    toString()