package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserRepository : JpaRepository<UserEntity, UUID> {

    fun findByUsername(
        username: String
    ): UserEntity?

    fun existsByUsername(
        username: String
    ): Boolean
}