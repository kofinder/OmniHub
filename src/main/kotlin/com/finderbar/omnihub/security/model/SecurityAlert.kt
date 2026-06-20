package com.finderbar.omnihub.security.model
data class SecurityAlert(
    val username: String,
    val type: String,
    val severity: Severity,
    val message: String,
    val ip: String? = null,
    val timestamp: Long = System.currentTimeMillis()
)