package com.finderbar.omnihub.security.handler
import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.security.access.AccessDeniedException
import org.springframework.security.web.access.AccessDeniedHandler
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class CustomAccessDeniedHandler(
    private val objectMapper: ObjectMapper
) : AccessDeniedHandler {

    override fun handle(
        request: HttpServletRequest,
        response: HttpServletResponse,
        accessDeniedException: AccessDeniedException
    ) {

        response.status =
            HttpServletResponse.SC_FORBIDDEN

        response.contentType =
            "application/json"

        val body = mapOf(
            "timestamp" to LocalDateTime.now(),
            "status" to 403,
            "error" to "Forbidden",
            "message" to (
                    accessDeniedException.message
                        ?: "Access denied"
                    ),
            "path" to request.servletPath
        )

        response.writer.write(
            objectMapper.writeValueAsString(body)
        )
    }
}