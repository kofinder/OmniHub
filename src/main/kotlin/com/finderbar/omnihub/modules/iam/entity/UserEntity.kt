package com.finderbar.omnihub.modules.iam.entity

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "users",
    indexes = [
        Index(
            name = "idx_user_username",
            columnList = "username",
            unique = true
        )
    ]
)
class UserEntity(

    @Column(
        name = "username",
        nullable = false,
        unique = true
    )
    var username: String,

    @Column(
        name = "password",
        nullable = false
    )
    var password: String,

    @Column(
        name = "email",
        nullable = false,
        unique = true
    )
    var email: String,

    @Column(
        name = "enabled",
        nullable = false
    )
    var enabled: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "office_id",
        foreignKey = ForeignKey(
            name = "fk_user_office"
        )
    )
    var office: OfficeEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "branch_id",
        foreignKey = ForeignKey(
            name = "fk_user_branch"
        )
    )
    var branch: BranchEntity? = null,

    @OneToMany(
        mappedBy = "user",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var authorities: MutableSet<UserAuthorityEntity> = mutableSetOf(),


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        schema = "iam",
        name = "user_role",
        joinColumns = [
            JoinColumn(name = "user_id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "role_id")
        ]
    )
    var roles: MutableSet<RoleEntity> = mutableSetOf()

) : BaseEntity()