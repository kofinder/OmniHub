package com.finderbar.omnihub.security.model

data class DeviceInfo(
    val ip: String,
    val userAgent: String,
    val deviceHash: String
)