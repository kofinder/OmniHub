package com.finderbar.omnihub.security.oauth2

import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AuthorizationGrantAuthenticationToken

class PasswordAuthenticationToken(
    val username: String,
    val password: String,
    principal: Authentication,
    val scopes: Set<String>
) : OAuth2AuthorizationGrantAuthenticationToken(
    AuthorizationGrantType("password"),
    principal,
    emptyMap()
)