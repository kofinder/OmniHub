package com.finderbar.omnihub.modules.iam.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(
    schema = "iam",
    name = "user_role",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_user_role",
            columnNames = [
                "user_account_id",
                "role_id"
            ]
        )
    ]
)
class UserRoleEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_account_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_user_role_user"
        )
    )
    var user: UserAccountEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "role_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_user_role_role"
        )
    )
    var role: RoleEntity

) : BaseEntity()