package com.finderbar.omnihub.modules.iam.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "permission"
)
class PermissionEntity(

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
    var description: String? = null

) : BaseEntity()