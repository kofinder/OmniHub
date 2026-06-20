package com.finderbar.omnihub.config.audit

import com.finderbar.omnihub.security.model.ApplicationUserPrincipal
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

            val authentication = SecurityContextHolder.getContext().authentication

            if (
                authentication == null ||
                !authentication.isAuthenticated
            ) {
                return@AuditorAware Optional.empty()
            }

            val principal = authentication.principal

            if (principal is ApplicationUserPrincipal) {

                return@AuditorAware Optional.of(
                    UUID.fromString(principal.id)
                )
            }

            Optional.empty()
        }
    }
}
