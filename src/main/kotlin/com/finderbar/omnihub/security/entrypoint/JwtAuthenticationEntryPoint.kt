package com.finderbar.omnihub.security.entrypoint

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.AuthenticationEntryPoint
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class JwtAuthenticationEntryPoint(private val objectMapper: ObjectMapper): AuthenticationEntryPoint {
    override fun commence(
        request: HttpServletRequest,
        response: HttpServletResponse,
        authException: AuthenticationException
    ) {
        response.status =
            HttpServletResponse.SC_UNAUTHORIZED

        response.contentType =
            "application/json"

        val body = mapOf(
            "timestamp" to LocalDateTime.now().toString(),
            "status" to 401,
            "error" to "Unauthorized",
            "message" to (
                    authException.message
                        ?: "Authentication required"
                    ),
            "path" to request.servletPath
        )

        response.writer.write(
            objectMapper.writeValueAsString(body)
        )
    }
}