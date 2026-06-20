package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "login_attempt"
)
class LoginAttemptEntity(

    @Column(
        name = "username",
        nullable = false
    )
    var username: String,

    @Column(
        name = "success",
        nullable = false
    )
    var success: Boolean,

    @Column(
        name = "ip_address"
    )
    var ipAddress: String? = null

) : BaseEntity()