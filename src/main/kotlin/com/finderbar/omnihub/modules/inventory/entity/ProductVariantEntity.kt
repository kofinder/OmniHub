package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*


@Entity
@Table(
    name = "inv_product_sku",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_inv_sku_code", columnNames = ["sku_code"]),
        UniqueConstraint(name = "uk_inv_sku_barcode", columnNames = ["barcode"])
    ],
    indexes = [
        Index(name = "idx_inv_sku_product", columnList = "product_id"),
        Index(name = "idx_inv_sku_unit", columnList = "unit_id")
    ]
)
class ProductVariantEntity(

    @Column(name = "sku_code", nullable = false, length = 100)
    var skuCode: String,

    @Column(length = 50)
    var barcode: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_id",
        foreignKey = ForeignKey(name = "fk_sku_product")
    )
    var product: ProductEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "unit_id",
        foreignKey = ForeignKey(name = "fk_sku_uom")
    )
    var unit: UnitOfMeasureEntity

) : BaseEntity()