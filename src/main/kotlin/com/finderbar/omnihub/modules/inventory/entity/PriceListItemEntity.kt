package com.finderbar.omnihub.modules.inventory.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "prc_price_list_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_price_list_sku",
            columnNames = [
                "price_list_id",
                "sku_id",
                "min_qty"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_price_list_item_price_list",
            columnList = "price_list_id"
        ),
        Index(
            name = "idx_price_list_item_sku",
            columnList = "sku_id"
        )
    ]
)
class PriceListItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "price_list_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_price_item_price_list")
    )
    var priceList: PriceListEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "sku_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_price_item_sku")
    )
    var sku: ProductVariantEntity,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var price: BigDecimal,

    @Column(
        name = "min_qty",
        precision = 19,
        scale = 4,
        nullable = false
    )
    var minQty: BigDecimal = BigDecimal.ONE

) : BaseEntity()