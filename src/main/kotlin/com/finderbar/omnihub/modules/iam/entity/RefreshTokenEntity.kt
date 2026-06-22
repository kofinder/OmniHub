package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime
@Entity
@Table(
    name = "iam_refresh_token",
    indexes = [
        Index(name = "idx_refresh_token_token", columnList = "token"),
        Index(name = "idx_refresh_token_user", columnList = "user_id")
    ]
)
class RefreshTokenEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    var user: UserAccountEntity,

    @Column(
        name = "token",
        nullable = false,
        unique = true,
        columnDefinition = "TEXT"
    )
    var token: String,

    @Column(
        name = "session_id",
        nullable = false,
        length = 100
    )
    var sessionId: String,

    @Column(
        name = "device_info",
        columnDefinition = "TEXT"
    )
    var deviceInfo: String? = null,

    @Column(
        name = "ip_address",
        length = 100
    )
    var ipAddress: String? = null,

    @Column(
        name = "expired_at",
        nullable = false
    )
    var expiredAt: LocalDateTime,

    @Column(
        name = "revoked",
        nullable = false
    )
    var revoked: Boolean = false,

    @Column(name = "device_hash")
    var deviceHash: String? = null,

    @Column(
        name = "used",
        nullable = false
    )
    var used: Boolean = false

) : BaseEntity()