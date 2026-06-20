package com.finderbar.omnihub.modules.core.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(
    schema = "core",
    name = "department",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_department_business_code",
            columnNames = [
                "business_id",
                "code"
            ]
        )
    ]
)
class DepartmentEntity(

    @Column(
        nullable = false,
        length = 255
    )
    var name: String,

    @Column(
        nullable = false,
        length = 100
    )
    var code: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "business_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_department_business"
        )
    )
    var business: BusinessEntity,

    @Column(
        columnDefinition = "TEXT"
    )
    var description: String? = null,

    @Column(
        nullable = false
    )
    var active: Boolean = true

) : BaseEntity()