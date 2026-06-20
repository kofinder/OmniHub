package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    schema = "iam",
    name = "refresh_token",
    indexes = [
        Index(
            name = "idx_refresh_token_token",
            columnList = "token"
        )
    ]
)
class RefreshTokenEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false
    )
    var user: UserEntity,

    @Column(
        name = "token",
        nullable = false,
        unique = true,
        columnDefinition = "TEXT"
    )
    var token: String,

    @Column(
        name = "expired_at",
        nullable = false
    )
    var expiredAt: LocalDateTime,

    @Column(name = "revoked")
    var revoked: Boolean = false

) : BaseEntity()