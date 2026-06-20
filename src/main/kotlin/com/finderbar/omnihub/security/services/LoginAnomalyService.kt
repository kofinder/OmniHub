package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.modules.iam.repository.RefreshTokenRepository
import com.finderbar.omnihub.security.model.RiskLevel
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.UUID

@Service
class LoginAnomalyService(
    private val refreshRepo: RefreshTokenRepository
) {

    fun isSuspicious(userId: UUID, deviceHash: String): Boolean {

        val existing = refreshRepo.findByUserId(userId)

        val knownDevices = existing.mapNotNull { it.deviceHash }

        return !knownDevices.contains(deviceHash)
    }

    fun detect(userId: UUID, deviceHash: String): RiskLevel {

        val active = refreshRepo.findByUserId(userId)
            .filter {
                !it.revoked &&
                        !it.used &&
                        it.expiredAt.isAfter(LocalDateTime.now())
            }

        val known = active.mapNotNull { it.deviceHash }

        return when {
            known.isEmpty() -> RiskLevel.MEDIUM
            !known.contains(deviceHash) -> RiskLevel.HIGH
            else -> RiskLevel.LOW
        }
    }
}