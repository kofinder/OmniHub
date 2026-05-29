package com.finderbar.omnihub.security.config

import com.finderbar.omnihub.security.handler.CustomAccessDeniedHandler
import com.finderbar.omnihub.security.handler.UnauthorizedEntryPoint
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val unauthorizedEntryPoint: UnauthorizedEntryPoint,
    private val customAccessDeniedHandler: CustomAccessDeniedHandler
) {

    @Bean
    @Order(2)
    fun apiSecurityFilterChain(
        http: HttpSecurity
    ): SecurityFilterChain {

        http
            .securityMatcher("/api/**")

            .csrf {
                it.disable()
            }

            .sessionManagement {
                it.sessionCreationPolicy(
                    SessionCreationPolicy.STATELESS
                )
            }

            .authorizeHttpRequests {

                it.requestMatchers(
                    "/api/auth/**"
                ).permitAll()

                it.anyRequest().authenticated()
            }

            .exceptionHandling {

                it.authenticationEntryPoint(
                    unauthorizedEntryPoint
                )

                it.accessDeniedHandler(
                    customAccessDeniedHandler
                )
            }

            .oauth2ResourceServer {
                it.jwt { }
            }

        return http.build()
    }

    @Bean
    @Order(3)
    fun webSecurityFilterChain(
        http: HttpSecurity
    ): SecurityFilterChain {

        http

            .authorizeHttpRequests {

                it.requestMatchers(
                    "/",
                    "/assets/**"
                ).permitAll()

                it.anyRequest().authenticated()
            }

            .formLogin { }

        return http.build()
    }
}