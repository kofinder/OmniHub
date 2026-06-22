package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    name = "iam_role",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_role_code",
            columnNames = ["code"]
        )
    ]
)
class RoleEntity(
    @Column(
        nullable = false,
        length = 100
    )
    var code: String,

    @Column(
        nullable = false,
        length = 255
    )
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @OneToMany(
        mappedBy = "role",
        fetch = FetchType.LAZY
    )
    var userRoles: MutableSet<UserRoleEntity> = mutableSetOf(),

    @OneToMany(
        mappedBy = "role",
        fetch = FetchType.LAZY
    )
    var rolePermissions: MutableSet<RolePermissionEntity> = mutableSetOf()
) : BaseEntity()