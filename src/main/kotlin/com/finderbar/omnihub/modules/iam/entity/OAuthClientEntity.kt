package com.finderbar.omnihub.modules.iam.entity

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*


@Entity
@Table(
    schema = "iam",
    name = "oauth_client",
    indexes = [
        Index(
            name = "idx_oauth_client_client_id",
            columnList = "client_id",
            unique = true
        )
    ]
)
class OAuthClientEntity(

    @Column(
        name = "client_id",
        nullable = false,
        unique = true,
        length = 200
    )
    var clientId: String,

    @Column(
        name = "client_secret",
        nullable = false,
        length = 500
    )
    var clientSecret: String,

    @Column(
        name = "client_name",
        nullable = false
    )
    var clientName: String,

    @Column(
        name = "redirect_uris",
        columnDefinition = "TEXT"
    )
    var redirectUris: String? = null,

    @Column(
        name = "scopes",
        columnDefinition = "TEXT"
    )
    var scopes: String? = null,

    @Column(
        name = "grant_types",
        columnDefinition = "TEXT"
    )
    var grantTypes: String? = null,

    @Column(
        name = "authentication_methods",
        columnDefinition = "TEXT"
    )
    var authenticationMethods: String? = null,

    @Column(
        name = "require_pkce",
        nullable = false
    )
    var requirePkce: Boolean = false,

    @Column(
        name = "require_consent",
        nullable = false
    )
    var requireConsent: Boolean = false,

    @Column(
        name = "access_token_ttl"
    )
    var accessTokenTtl: Long = 3600,

    @Column(
        name = "refresh_token_ttl"
    )
    var refreshTokenTtl: Long = 86400,

    @Column(
        name = "active",
        nullable = false
    )
    var active: Boolean = true

) : BaseEntity()



//
//@Entity
//@Table(
//    schema = "iam",
//    name = "oauth_client"
//)
//class OAuthClientEntity(
//
//    @Column(
//        name = "client_id",
//        nullable = false,
//        unique = true
//    )
//    var clientId: String,
//
//    @Column(
//        name = "client_secret",
//        nullable = false
//    )
//    var clientSecret: String,
//
//    @Column(
//        name = "redirect_uri",
//        columnDefinition = "TEXT"
//    )
//    var redirectUri: String? = null,
//
//    @Column(
//        name = "scopes",
//        columnDefinition = "TEXT"
//    )
//    var scopes: String? = null,
//
//    @Column(name = "active")
//    var active: Boolean = true
//
//) : BaseEntity()