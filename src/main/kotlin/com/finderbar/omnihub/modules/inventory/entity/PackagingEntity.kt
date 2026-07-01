package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "inv_package",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_inv_package_code", columnNames = ["code"])
    ],
    indexes = [
        Index(name = "idx_inv_package_unit", columnList = "unit_id")
    ]
)
class PackagingEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 100)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(nullable = false, precision = 19, scale = 6)
    var conversionQty: BigDecimal = BigDecimal.ONE,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "unit_id",
        foreignKey = ForeignKey(name = "fk_package_uom")
    )
    var unit: UnitOfMeasureEntity
) : BaseEntity()