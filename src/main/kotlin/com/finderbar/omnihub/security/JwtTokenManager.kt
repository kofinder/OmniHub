package com.finderbar.omnihub.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.util.Date
import javax.crypto.SecretKey

@Service
class JwtTokenManager(
    @Value("\${jwt.secret}")
    private val secret: String,

    @Value("\${jwt.expiration}")
    private val expiration: Long
) {

    private fun getKey(): SecretKey =
        Keys.hmacShaKeyFor(secret.toByteArray())

    fun generateToken(username: String, userId: String): String {

        return Jwts.builder()
            .subject(username)
            .claim("userId", userId)
            .claim("username", username)
            .issuedAt(Date())
            .expiration(Date(System.currentTimeMillis() + expiration))
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

    private fun getClaims(token: String): Claims {
        return Jwts.parser()
            .verifyWith(getKey())
            .build()
            .parseSignedClaims(token)
            .payload
    }
}