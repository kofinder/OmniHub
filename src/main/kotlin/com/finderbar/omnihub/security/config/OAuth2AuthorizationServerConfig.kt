package com.finderbar.omnihub.security.config

import com.nimbusds.jose.jwk.JWKSet
import com.nimbusds.jose.jwk.RSAKey
import com.nimbusds.jose.jwk.source.ImmutableJWKSet
import com.nimbusds.jose.jwk.source.JWKSource
import com.nimbusds.jose.proc.SecurityContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod
import org.springframework.security.oauth2.jwt.JwtDecoder
import org.springframework.security.oauth2.server.authorization.client.InMemoryRegisteredClientRepository
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.interfaces.RSAPrivateKey
import java.security.interfaces.RSAPublicKey
import java.util.*

@Configuration
class OAuth2AuthorizationServerConfig(
    private val passwordEncoder: PasswordEncoder
) {

    @Bean
    @Order(1)
    fun authorizationServerSecurityFilterChain(
        http: HttpSecurity
    ): SecurityFilterChain {

        val authorizationServerConfigurer =
            OAuth2AuthorizationServerConfigurer()

        http
            .securityMatcher(
                authorizationServerConfigurer.endpointsMatcher
            )

            .with(
                authorizationServerConfigurer
            ) {
                it.oidc(Customizer.withDefaults())
            }

            .authorizeHttpRequests {
                it.anyRequest().authenticated()
            }

            .exceptionHandling {
                it.authenticationEntryPoint(
                    LoginUrlAuthenticationEntryPoint(
                        "/login"
                    )
                )
            }

        return http.build()
    }

    @Bean
    fun registeredClientRepository(): RegisteredClientRepository {

        val registeredClient = RegisteredClient.withId(
            UUID.randomUUID().toString()
        )
            .clientId("omnihub-client")

            .clientSecret(
                passwordEncoder.encode("secret")
            )

            .clientAuthenticationMethod(
                ClientAuthenticationMethod.CLIENT_SECRET_BASIC
            )

            .authorizationGrantType(
                AuthorizationGrantType.AUTHORIZATION_CODE
            )

            .authorizationGrantType(
                AuthorizationGrantType.REFRESH_TOKEN
            )

            .redirectUri(
                "http://127.0.0.1:3000/login/oauth2/code/omnihub"
            )

            .scope("openid")
            .scope("profile")
            .scope("read")
            .scope("write")

            .build()

        return InMemoryRegisteredClientRepository(
            registeredClient
        )
    }

    @Bean
    fun jwkSource(): JWKSource<SecurityContext> {

        val keyPair = generateRsaKey()

        val rsaKey = RSAKey.Builder(
            keyPair.public as RSAPublicKey
        )
            .privateKey(
                keyPair.private as RSAPrivateKey
            )
            .keyID(
                UUID.randomUUID().toString()
            )
            .build()

        val jwkSet = JWKSet(rsaKey)

        return ImmutableJWKSet(jwkSet)
    }

    @Bean
    fun jwtDecoder(
        jwkSource: JWKSource<SecurityContext>
    ): JwtDecoder {

        return OAuth2AuthorizationServerConfiguration
            .jwtDecoder(jwkSource)
    }

    private fun generateRsaKey(): KeyPair {

        val keyPairGenerator =
            KeyPairGenerator.getInstance("RSA")

        keyPairGenerator.initialize(2048)

        return keyPairGenerator.generateKeyPair()
    }
}