package com.finderbar.omnihub.modules.iam.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
@Entity
@Table(
    name = "iam_permission",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_permission_code",
            columnNames = ["code"]
        )
    ]
)
class PermissionEntity(

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
    var description: String? = null

) : BaseEntity()