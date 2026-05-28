package com.finderbar.omnihub.security.jwt

import com.finderbar.omnihub.security.service.CustomUserDetails
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

////        val principal =
////            context.principal.principal
////
////        if (principal !is CustomUserDetails) {
////            return
////        }
//
//        val user =
//            principal.getUser()
//
//        val claims: JwtClaimsSet.Builder =
//            context.claims
//
//        claims.claim(
//            JwtClaimNames.USER_ID,
//            user.id.toString()
//        )
//
//        claims.claim(
//            JwtClaimNames.USERNAME,
//            user.username
//        )
//
//        claims.claim(
//            JwtClaimNames.EMAIL,
//            user.email
//        )
//
//        claims.claim(
//            JwtClaimNames.OFFICE_ID,
//            user.office?.id?.toString()
//        )
//
//        claims.claim(
//            JwtClaimNames.BRANCH_ID,
//            user.branch?.id?.toString()
//        )
//
//        claims.claim(
//            JwtClaimNames.AUTHORITIES,
//            principal.authorities.map {
//                it.authority
//            }
//        )
    }
}