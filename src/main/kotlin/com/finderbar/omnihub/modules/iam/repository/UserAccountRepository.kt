package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface UserAccountRepository : JpaRepository<UserAccountEntity, UUID> {

    fun findByUsername(
        username: String
    ): UserAccountEntity?

    fun existsByUsername(
        username: String
    ): Boolean

    fun existsByEmployeeId(employeeId: UUID): Boolean
}