package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import java.util.Date
import javax.crypto.SecretKey

@Service
class JwtTokenService(
    @Value("\${jwt.secret}")
    private val secret: String,

    @Value("\${jwt.expiration}")
    private val expiration: Long
) {

    private fun getKey(): SecretKey =
        Keys.hmacShaKeyFor(secret.toByteArray())

    fun generateToken(user: UserDetails): String {

        return Jwts.builder()
            .subject(user.username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expiration))
            .setExpiration(Date(System.currentTimeMillis() + 1000 * 60 * 15))
            .signWith(getKey())
            .compact()
    }

    fun extractUserId(token: String): String {
        return getClaims(token).get("userId", String::class.java)
    }

    fun extractUsername(token: String): String {

        return getClaims(token).subject
    }

    fun validate(token: String): Boolean {

        return try {
            getClaims(token)
            true
        } catch (e: Exception) {
            false
        }
    }

    fun validate(token: String, user: UserAccountEntity): Boolean {
        val claims = getClaims(token)
        val tokenVersion = claims.get("tokenVersion", Int::class.java)

        return tokenVersion == user.tokenVersion
    }

    fun extractTokenVersion(token: String): Int {
        return getClaims(token).get("tokenVersion", Int::class.java)
    }

    fun extractRoles(token: String): List<String> {
        return getClaims(token).get("roles", List::class.java) as List<String>
    }

    fun extractPermissions(token: String): List<String> {
        return getClaims(token).get("permissions", List::class.java) as List<String>
    }

    private fun getClaims(token: String): Claims {
        return Jwts.parser()
            .verifyWith(getKey())
            .build()
            .parseSignedClaims(token)
            .payload
    }
}