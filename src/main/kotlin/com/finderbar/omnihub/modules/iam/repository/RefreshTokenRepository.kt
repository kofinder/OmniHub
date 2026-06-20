package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.RefreshTokenEntity
import com.finderbar.omnihub.modules.iam.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface RefreshTokenRepository : JpaRepository<RefreshTokenEntity, UUID> {

    fun findByToken(token: String): RefreshTokenEntity?

    fun findAllByUser(user: UserEntity): List<RefreshTokenEntity>

    fun deleteAllByUser(user: UserEntity)

    fun deleteByToken(token: String)
}