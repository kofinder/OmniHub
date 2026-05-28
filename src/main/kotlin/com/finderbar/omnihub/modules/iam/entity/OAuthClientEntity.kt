package com.finderbar.omnihub.modules.iam.entity

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*


@Entity
@Table(
    schema = "iam",
    name = "oauth_client"
)
class OAuthClientEntity(

    @Column(
        name = "client_id",
        nullable = false,
        unique = true
    )
    var clientId: String,

    @Column(
        name = "client_secret",
        nullable = false
    )
    var clientSecret: String,

    @Column(
        name = "redirect_uri",
        columnDefinition = "TEXT"
    )
    var redirectUri: String? = null,

    @Column(
        name = "scopes",
        columnDefinition = "TEXT"
    )
    var scopes: String? = null,

    @Column(name = "active")
    var active: Boolean = true

) : BaseEntity()