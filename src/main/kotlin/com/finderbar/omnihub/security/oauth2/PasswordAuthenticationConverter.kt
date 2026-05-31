package com.finderbar.omnihub.security.oauth2

import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken
import org.springframework.security.web.authentication.AuthenticationConverter

class PasswordAuthenticationConverter : AuthenticationConverter {

    override fun convert(
        request: HttpServletRequest
    ): Authentication? {

        val grantType =
            request.getParameter("grant_type")

        // only handle password grant
        if (grantType != "password") {
            return null
        }

        val username =
            request.getParameter("username")

        val password =
            request.getParameter("password")

        val scope =
            request.getParameter("scope")

        val clientPrincipal =
            SecurityContextHolder
                .getContext()
                .authentication as OAuth2ClientAuthenticationToken

        val scopes =
            if (!scope.isNullOrBlank()) {
                scope.split(" ").toSet()
            } else {
                emptySet()
            }

        return PasswordAuthenticationToken(
            username = username,
            password = password,
            principal = clientPrincipal,
            scopes = scopes
        )
    }
}