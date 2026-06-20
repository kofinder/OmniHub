package com.finderbar.omnihub.modules.core.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table


@Entity
@Table(
    schema = "core",
    name = "position"
)
class PositionEntity(

    @Column(
        nullable = false,
        unique = true,
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

    @Column(nullable = false)
    var active: Boolean = true

) : BaseEntity()