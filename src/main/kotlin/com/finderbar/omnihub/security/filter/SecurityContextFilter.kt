package com.finderbar.omnihub.security.filter

import com.finderbar.omnihub.security.model.SecurityContext
import com.finderbar.omnihub.security.model.SecurityContextHolder
import com.finderbar.omnihub.security.services.ClientIpResolver
import com.finderbar.omnihub.security.services.DeviceFingerprintService
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.util.UUID

@Component
class SecurityContextFilter(
    private val clientIpResolver: ClientIpResolver,
    private val deviceFingerprintService: DeviceFingerprintService
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {

            val ip = clientIpResolver.getClientIp(request)
            val userAgent = request.getHeader("User-Agent")
            val device = deviceFingerprintService.generate(request)

            val requestId = UUID.randomUUID().toString()

            val ctx = SecurityContext(
                ip = ip,
                userAgent = userAgent,
                deviceHash = device.deviceHash,
                requestId = requestId
            )

            SecurityContextHolder.set(ctx)

            filterChain.doFilter(request, response)

        } finally {
            SecurityContextHolder.clear()
        }
    }
}