package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal


@Entity
@Table(
    schema = "inventory",
    name = "item",
    indexes = [
//        Index(name = "idx_item_business_id", columnList = "business_id"),
        Index(name = "idx_item_product_id", columnList = "product_id")
    ]
)
class ItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_item_product")
    )
    var product: ProductEntity,

    @Column(
        name = "cost_price",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var costPrice: BigDecimal = BigDecimal.ZERO,

    @Column(
        name = "sale_price",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var salePrice: BigDecimal = BigDecimal.ZERO,

    @Column(name = "currency", nullable = false, length = 10)
    var currency: String = "MMK",

    @Column(name = "quantity", nullable = false)
    var quantity: BigDecimal = BigDecimal.ZERO,

    @Column(name = "min_quantity", nullable = false)
    var minQuantity: BigDecimal = BigDecimal.ZERO,

    @Column(name = "active", nullable = false)
    var active: Boolean = true

) : BaseEntity()