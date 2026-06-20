package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "role"
)
class RoleEntity(

    @Column(
        name = "name",
        nullable = false,
        unique = true
    )
    var name: String,

    @Column(
        name = "code",
        nullable = false,
        unique = true
    )
    var code: String,

    @Column(
        name = "description",
        columnDefinition = "TEXT"
    )
    var description: String? = null,

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        schema = "iam",
        name = "role_permission",
        joinColumns = [
            JoinColumn(name = "role_id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "permission_id")
        ]
    )
    var permissions: MutableSet<PermissionEntity> = mutableSetOf()

) : BaseEntity()