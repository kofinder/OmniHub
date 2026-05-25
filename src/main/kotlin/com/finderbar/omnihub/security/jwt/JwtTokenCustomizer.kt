package com.finderbar.omnihub.security.jwt

import com.finderbar.omnihub.modules.iam.UserEntity
import org.springframework.security.core.Authentication
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer
import org.springframework.stereotype.Component

@Component
class JwtTokenCustomizer :
    OAuth2TokenCustomizer<JwtEncodingContext> {

    override fun customize(
        context: JwtEncodingContext
    ) {

        val principal =
            context.principal.principal

        if (principal !is UserEntity) {
            return
        }

        val claims: JwtClaimsSet.Builder =
            context.claims

        claims.claim(
            JwtClaimNames.USER_ID,
            principal.id.toString()
        )

        claims.claim(
            JwtClaimNames.USERNAME,
            principal.username
        )

        claims.claim(
            JwtClaimNames.EMAIL,
            principal.email
        )

        claims.claim(
            JwtClaimNames.OFFICE_ID,
            principal.office?.id?.toString()
        )

        claims.claim(
            JwtClaimNames.BRANCH_ID,
            principal.branch?.id?.toString()
        )

        claims.claim(
            JwtClaimNames.AUTHORITIES,
            principal.authorities.map {
                it.authority
            }
        )
    }
}