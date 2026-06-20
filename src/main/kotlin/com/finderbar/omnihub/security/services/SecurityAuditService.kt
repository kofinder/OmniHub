package com.finderbar.omnihub.security.services

import com.finderbar.omnihub.modules.iam.entity.SecurityAuditLogEntity
import com.finderbar.omnihub.modules.iam.repository.SecurityAuditLogRepository
import com.finderbar.omnihub.modules.utility.SecurityEventType
import com.finderbar.omnihub.security.model.SecurityContextHolder
import org.springframework.stereotype.Service

@Service
class SecurityAuditService(
    private val repo: SecurityAuditLogRepository
) {

    fun log(
        username: String,
        eventType: SecurityEventType,
        success: Boolean,
        ip: String? = null,
        details: String? = null
    ) {
        val ctx = SecurityContextHolder.get()

        repo.save(
            SecurityAuditLogEntity(
                username = username,
                eventType = eventType,
                success = success,
                ipAddress = ip,
                userAgent = ctx?.userId,
                details = details
            )
        )
    }
}