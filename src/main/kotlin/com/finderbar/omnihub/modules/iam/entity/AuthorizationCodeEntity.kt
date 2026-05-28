package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(
    schema = "iam",
    name = "authorization_code",
    indexes = [
        Index(
            name = "idx_authorization_code_code",
            columnList = "code"
        )
    ]
)
class AuthorizationCodeEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_authorization_code_user"
        )
    )
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "oauth_client_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_authorization_code_client"
        )
    )
    var client: OAuthClientEntity,

    @Column(
        name = "code",
        nullable = false,
        unique = true,
        columnDefinition = "TEXT"
    )
    var code: String,

    @Column(
        name = "redirect_uri",
        nullable = false,
        columnDefinition = "TEXT"
    )
    var redirectUri: String,

    @Column(
        name = "scopes",
        columnDefinition = "TEXT"
    )
    var scopes: String? = null,

    @Column(
        name = "expired_at",
        nullable = false
    )
    var expiredAt: LocalDateTime,

    @Column(name = "used")
    var used: Boolean = false

) : BaseEntity()