package com.finderbar.omnihub.modules.iam.services

import com.finderbar.omnihub.modules.iam.repository.RefreshTokenRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class RefreshTokenService(
    private val refreshTokenRepository: RefreshTokenRepository
) {

    companion object {
        private const val REFRESH_TOKEN_DAYS = 7L
    }

    @Transactional
    fun create(user: UserEntity): RefreshTokenEntity {

        val refreshToken = RefreshTokenEntity(
            token = UUID.randomUUID().toString(),
            user = user,
            expiresAt = LocalDateTime.now()
                .plusDays(REFRESH_TOKEN_DAYS)
        )

        return refreshTokenRepository.save(refreshToken)
    }

    @Transactional(readOnly = true)
    fun validate(token: String): RefreshTokenEntity {

        val refreshToken =
            refreshTokenRepository.findByToken(token)
                ?: throw IllegalArgumentException(
                    "Invalid refresh token"
                )

        if (refreshToken.revoked) {
            throw IllegalArgumentException(
                "Refresh token revoked"
            )
        }

        if (
            refreshToken.expiresAt.isBefore(
                LocalDateTime.now()
            )
        ) {
            throw IllegalArgumentException(
                "Refresh token expired"
            )
        }

        return refreshToken
    }

    @Transactional
    fun revoke(token: String) {
        val refreshToken = refreshTokenRepository.findByToken(token) ?: return
        refreshToken.revoked = true
        refreshTokenRepository.save(refreshToken)
    }

    @Transactional
    fun revokeAll(user: UserEntity) {
        refreshTokenRepository
            .findAllByUser(user)
            .forEach {
                it.revoked = true
            }
    }
}