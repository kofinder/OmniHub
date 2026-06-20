package com.finderbar.omnihub.modules.iam.repository

import com.finderbar.omnihub.modules.iam.entity.PermissionEntity
import com.finderbar.omnihub.modules.iam.entity.SecurityAuditLogEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID



@Repository
interface SecurityAuditLogRepository : JpaRepository<SecurityAuditLogEntity, UUID> {
}