package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.PermissionEntity
import com.finderbar.omnihub.modules.iam.entity.UserAccountEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID


@Repository
interface PermissionRepository : JpaRepository<PermissionEntity, UUID> {
    @Query("""
        SELECT p
        FROM PermissionEntity p
        JOIN RolePermissionEntity rp ON rp.permission = p
        JOIN UserRoleEntity ur ON ur.role = rp.role
        WHERE ur.user.id = :userId
    """)
    fun findPermissionsByUserId(userId: UUID): List<PermissionEntity>
}