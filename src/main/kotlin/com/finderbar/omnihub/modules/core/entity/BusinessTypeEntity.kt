package com.finderbar.omnihub.modules.core.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint


@Entity
@Table(
    schema = "core",
    name = "business_type",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_business_type_code",
            columnNames = ["code"]
        )
    ]
)
class BusinessTypeEntity(

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

    @Column(
        columnDefinition = "TEXT"
    )
    var description: String? = null,

    @Column(
        nullable = false
    )
    var active: Boolean = true

) : BaseEntity()