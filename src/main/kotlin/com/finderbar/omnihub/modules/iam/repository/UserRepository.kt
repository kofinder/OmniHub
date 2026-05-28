package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<UserEntity, UUID> {

    fun findByUsername(
        username: String
    ): UserEntity?

    fun existsByUsername(
        username: String
    ): Boolean
}