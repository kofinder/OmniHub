package com.finderbar.omnihub.security.provider

import com.finderbar.omnihub.security.oauth2.PasswordAuthenticationToken
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.core.OAuth2Token
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenGenerator
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.OAuth2AccessToken
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization
import org.springframework.security.oauth2.server.authorization.OAuth2TokenType
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2AccessTokenAuthenticationToken
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken
import org.springframework.security.oauth2.server.authorization.context.AuthorizationServerContextHolder
import org.springframework.security.oauth2.server.authorization.token.DefaultOAuth2TokenContext

class PasswordAuthenticationProvider(
    private val authenticationManager: AuthenticationManager,
    private val authorizationService: OAuth2AuthorizationService,
    private val tokenGenerator: OAuth2TokenGenerator<OAuth2Token>
) : AuthenticationProvider {

    override fun authenticate(
        authentication: Authentication
    ): Authentication {

        val passwordAuthentication =
            authentication as PasswordAuthenticationToken

        // -----------------------------------------
        // Authenticate Username / Password
        // -----------------------------------------
        val usernamePasswordAuthentication =
            UsernamePasswordAuthenticationToken(
                passwordAuthentication.username,
                passwordAuthentication.password
            )

        val userAuthentication =
            authenticationManager.authenticate(
                usernamePasswordAuthentication
            )

        // -----------------------------------------
        // OAuth2 Client
        // -----------------------------------------
        val clientPrincipal =
            passwordAuthentication.principal
                    as OAuth2ClientAuthenticationToken

        val registeredClient =
            clientPrincipal.registeredClient

        // -----------------------------------------
        // Token Context
        // -----------------------------------------
        val tokenContext =
            DefaultOAuth2TokenContext.builder()
                .registeredClient(registeredClient)
                .principal(userAuthentication)
                .authorizationServerContext(
                    AuthorizationServerContextHolder.getContext()
                )
                .authorizationGrantType(
                    AuthorizationGrantType("password")
                )
                .authorizationGrant(
                    passwordAuthentication
                )
                .tokenType(
                    OAuth2TokenType.ACCESS_TOKEN
                )
                .authorizedScopes(
                    passwordAuthentication.scopes
                )
                .build()

        // -----------------------------------------
        // Generate JWT Access Token
        // -----------------------------------------
        val generatedToken =
            tokenGenerator.generate(tokenContext)
                ?: throw IllegalStateException(
                    "Failed to generate token"
                )

        val accessToken =
            generatedToken as OAuth2AccessToken

        // -----------------------------------------
        // Save Authorization
        // -----------------------------------------
        val authorization =
            OAuth2Authorization.withRegisteredClient(
                registeredClient
            )
                .principalName(userAuthentication.name)
                .authorizationGrantType(
                    AuthorizationGrantType("password")
                )
                .authorizedScopes(
                    passwordAuthentication.scopes
                )
                .accessToken(accessToken)
                .build()

        authorizationService.save(authorization)

        // -----------------------------------------
        // Return OAuth2 Token Response
        // -----------------------------------------
        return OAuth2AccessTokenAuthenticationToken(
            registeredClient,
            clientPrincipal,
            accessToken
        )
    }

    override fun supports(
        authentication: Class<*>
    ): Boolean {

        return PasswordAuthenticationToken::class.java
            .isAssignableFrom(authentication)
    }
}
