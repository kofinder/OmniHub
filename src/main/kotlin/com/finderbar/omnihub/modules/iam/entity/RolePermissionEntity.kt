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
    name = "iam_role_permission",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_role_permission",
            columnNames = [
                "role_id",
                "permission_id"
            ]
        )
    ]
)
class RolePermissionEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "role_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_role_permission_role"
        )
    )
    var role: RoleEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "permission_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_role_permission_permission"
        )
    )
    var permission: PermissionEntity

) : BaseEntity()