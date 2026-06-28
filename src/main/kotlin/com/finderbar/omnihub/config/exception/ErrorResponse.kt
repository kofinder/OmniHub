package com.finderbar.omnihub.config.exception

import java.time.Instant

data class ErrorResponse(
    val success: Boolean = false,
    val code: String,
    val message: String,
    val timestamp: Instant = Instant.now(),
    val path: String? = null,
    val details: Map<String, Any>? = null
)