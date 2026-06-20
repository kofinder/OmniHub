package com.finderbar.omnihub.modules.iam.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "audit_log"
)
class SecurityAuditLogEntity(

    @Column(
        name = "username",
        nullable = false
    )
    var username: String,

    @Column(
        name = "event_type",
        nullable = false
    )
    var eventType: String,

    @Column(
        name = "success",
        nullable = false
    )
    var success: Boolean,

    @Column(
        name = "ip_address"
    )
    var ipAddress: String? = null,

    @Column(
        name = "user_agent",
        columnDefinition = "TEXT"
    )
    var userAgent: String? = null,

    @Column(
        name = "details",
        columnDefinition = "TEXT"
    )
    var details: String? = null

) : BaseEntity()