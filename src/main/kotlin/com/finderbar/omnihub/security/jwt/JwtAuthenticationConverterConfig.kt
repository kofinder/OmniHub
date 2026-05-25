package com.finderbar.omnihub.security.jwt

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.jwt.Jwt
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter

@Configuration
class JwtAuthenticationConverterConfig {

    @Bean
    fun jwtAuthenticationConverter():
            Converter<Jwt, out AbstractAuthenticationToken> {

        val converter =
            JwtAuthenticationConverter()

        converter.setJwtGrantedAuthoritiesConverter { jwt ->

            val authorities =
                jwt.getClaimAsStringList(
                    JwtClaimNames.AUTHORITIES
                ) ?: emptyList()

            authorities.map {
                SimpleGrantedAuthority(it)
            }
        }

        return converter
    }
}