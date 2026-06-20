package com.finderbar.omnihub.security.model


data class SecurityContext(
    val userId: String? = null,
    val username: String? = null,
    val ip: String,
    val userAgent: String? = null,
    val deviceHash: String? = null,
    val requestId: String,
    val roles: List<String> = emptyList(),
    val permissions: List<String> = emptyList()
)