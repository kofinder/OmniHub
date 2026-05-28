package com.finderbar.omnihub.security.config
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain

@Configuration
class ResourceServerConfig {

    @Bean
    @Order(2)
    fun resourceSecurityFilterChain(
        http: HttpSecurity
    ): SecurityFilterChain {

        http

            .securityMatcher(
                "/api/**",
                "/graphql/**"
            )

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

                it.requestMatchers(
                    "/graphql"
                ).authenticated()
                it.anyRequest().authenticated()
            }

            .oauth2ResourceServer {
                it.jwt(
                    Customizer.withDefaults()
                )
            }

        return http.build()
    }
}