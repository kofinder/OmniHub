package com.finderbar.omnihub.modules.iam.services

import com.finderbar.omnihub.modules.iam.entity.RefreshTokenEntity
import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import com.finderbar.omnihub.modules.iam.repository.RefreshTokenRepository
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*

@Service
class RefreshTokenService(
    private val repo: RefreshTokenRepository
) {

    fun create(
        user: UserAccountEntity,
        sessionId: String,
        ip: String?
    ): RefreshTokenEntity {

        val token = UUID.randomUUID().toString()
        return repo.save(
            RefreshTokenEntity(
                user = user,
                token = token,
                sessionId = sessionId,
                expiredAt = LocalDateTime.now().plusDays(7),
                ipAddress = ip
            )
        )
    }

    fun validate(token: String): RefreshTokenEntity {

        val stored = repo.findByToken(token)
            ?: throw RuntimeException("Invalid refresh token")

        if (stored.revoked) throw RuntimeException("Token revoked")

        if (stored.used) throw RuntimeException("Token already used")

        if (stored.expiredAt.isBefore(LocalDateTime.now())) {
            throw RuntimeException("Token expired")
        }

        return stored
    }

    fun revoke(token: RefreshTokenEntity) {
        token.revoked = true
        repo.save(token)
    }

    fun markUsed(token: RefreshTokenEntity) {
        token.used = true
        repo.save(token)
    }
}
