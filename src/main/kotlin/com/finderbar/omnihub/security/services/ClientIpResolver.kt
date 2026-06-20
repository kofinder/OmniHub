package com.finderbar.omnihub.security.services

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Component


@Component
class ClientIpResolver {

    fun getClientIp(request: HttpServletRequest): String {

        val headers = listOf(
            "CF-Connecting-IP",        // Cloudflare
            "X-Forwarded-For",         // Standard proxy
            "X-Real-IP",               // Nginx
            "Proxy-Client-IP",
            "WL-Proxy-Client-IP"
        )

        for (header in headers) {
            val ip = request.getHeader(header)
            if (!ip.isNullOrBlank() && ip != "unknown") {
                return ip.split(",")[0].trim()
            }
        }

        return request.remoteAddr
    }
}