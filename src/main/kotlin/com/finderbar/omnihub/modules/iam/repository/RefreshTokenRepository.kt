package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.RefreshTokenEntity
import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface RefreshTokenRepository : JpaRepository<RefreshTokenEntity, UUID> {

    fun findByUserId(userId: UUID): List<RefreshTokenEntity>

    fun findByToken(token: String): RefreshTokenEntity?

    fun findAllByUser(user: UserAccountEntity): List<RefreshTokenEntity>

    fun deleteAllByUser(user: UserAccountEntity)

    fun deleteByToken(token: String)
}