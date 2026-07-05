package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.math.BigDecimal

@Entity
@Table(
    name = "inv_uom",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_inv_uom_code", columnNames = ["code"])
    ],
    indexes = [
        Index(name = "idx_inv_uom_base", columnList = "base_unit_id")
    ]
)
class UnitOfMeasureEntity(

    @Column(nullable = false, length = 30)
    var code: String,

    @Column(nullable = false, length = 100)
    var name: String,

    @Column(nullable = false, length = 20)
    var symbol: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "base_unit_id",
        foreignKey = ForeignKey(name = "fk_uom_base")
    )
    var baseUnit: UnitOfMeasureEntity? = null,

    @Column(nullable = false, precision = 19, scale = 6)
    var baseUnitRatio: BigDecimal = BigDecimal.ONE,

    @OneToMany(mappedBy = "baseUnit")
    @BatchSize(size = 50)
    var derivedUnits: MutableSet<UnitOfMeasureEntity> = linkedSetOf(),

    @OneToMany(mappedBy = "unit")
    @BatchSize(size = 50)
    var productVariants: MutableSet<ProductVariantEntity> = linkedSetOf(),

    @OneToMany(mappedBy = "unit")
    @BatchSize(size = 50)
    var packages: MutableSet<PackagingEntity> = linkedSetOf()

) : BaseEntity()