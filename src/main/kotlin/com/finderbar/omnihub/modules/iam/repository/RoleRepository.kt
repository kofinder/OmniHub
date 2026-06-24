package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface RoleRepository : JpaRepository<RoleEntity, UUID>, JpaSpecificationExecutor<RoleEntity> {

    @Query("""
        SELECT r
        FROM RoleEntity r
        JOIN UserRoleEntity ur ON ur.role = r
        WHERE ur.user.id = :userId
    """)
    fun findRolesByUserId(userId: UUID): List<RoleEntity>

    fun findByName(name: String): RoleEntity?

    fun findByCode(code: String): RoleEntity?
}