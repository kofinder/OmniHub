package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.security.model.DeviceInfo
import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component
import java.security.MessageDigest

@Component
class DeviceFingerprintService {

    fun generate(request: HttpServletRequest): DeviceInfo {

        val ip = request.remoteAddr
        val userAgent = request.getHeader("User-Agent") ?: "unknown"

        val raw = "$ip|$userAgent"

        val hash = MessageDigest.getInstance("SHA-256")
            .digest(raw.toByteArray())
            .joinToString("") { "%02x".format(it) }

        return DeviceInfo(
            ip = ip,
            userAgent = userAgent,
            deviceHash = hash
        )
    }
}