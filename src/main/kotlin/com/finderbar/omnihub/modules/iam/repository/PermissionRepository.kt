package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.PermissionEntity
import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface PermissionRepository : JpaRepository<PermissionEntity, UUID> {
    fun findPermissionsByUserId(userId: UUID): List<PermissionEntity>
}