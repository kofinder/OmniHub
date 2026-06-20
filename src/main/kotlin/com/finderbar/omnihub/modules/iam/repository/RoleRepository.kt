package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.RoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.UUID

interface RoleRepository : JpaRepository<RoleEntity, UUID>, JpaSpecificationExecutor<RoleEntity> {
    fun findByName(name: String): RoleEntity?
    fun findByCode(code: String): RoleEntity?
}