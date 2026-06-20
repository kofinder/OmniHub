package com.finderbar.omnihub.modules.iam.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.utility.SecurityEventType
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(schema = "iam", name = "security_audit_log")
class SecurityAuditLogEntity(

    @Column(nullable = false)
    var username: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    var eventType: SecurityEventType,

    @Column(nullable = false)
    var eventTime: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    var success: Boolean,

    @Column(name = "ip_address")
    var ipAddress: String? = null,

    @Column(columnDefinition = "TEXT")
    var userAgent: String? = null,

    @Column(columnDefinition = "TEXT")
    var details: String? = null

) : BaseEntity()
