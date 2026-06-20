package com.finderbar.omnihub.config.audit


import com.finderbar.omnihub.security.ApplicationUserPrincipal
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.security.core.context.SecurityContextHolder
import java.util.Optional
import java.util.UUID

@Configuration
class AuditorConfig {
    @Bean
    fun auditorProvider(): AuditorAware<UUID> {
        return AuditorAware {
            val auth = SecurityContextHolder.getContext().authentication

            println("AUDITOR AUTH = $auth")

            val principal = auth?.principal

            if (principal is ApplicationUserPrincipal) {
                println("AUDITOR USER ID = ${principal.id}")
                Optional.of(principal.id)
            } else {
                println("NO VALID PRINCIPAL")
                Optional.empty()
            }
        }
    }
}