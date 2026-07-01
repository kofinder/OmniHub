package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.AdjustmentType
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "inv_stock_adjustment_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_adjustment_item",
            columnNames = [
                "adjustment_id",
                "line_no"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_adjustment_item_adjustment",
            columnList = "adjustment_id"
        ),
        Index(
            name = "idx_adjustment_item_variant",
            columnList = "product_variant_id"
        ),
        Index(
            name = "idx_adjustment_item_location",
            columnList = "location_id"
        )
    ]
)
class StockAdjustmentItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "adjustment_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_adjustment_item_adjustment")
    )
    var adjustment: StockAdjustmentEntity,

    @Column(
        name = "line_no",
        nullable = false
    )
    var lineNo: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_adjustment_item_variant")
    )
    var productVariant: ProductVariantEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_adjustment_item_location")
    )
    var location: WarehouseLocationEntity,

    @Enumerated(EnumType.STRING)
    @Column(
        name = "adjustment_type",
        nullable = false,
        length = 20
    )
    var adjustmentType: AdjustmentType,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var quantity: BigDecimal,

    @Column(
        precision = 19,
        scale = 4
    )
    var unitCost: BigDecimal? = null,

    @Column(columnDefinition = "TEXT")
    var reason: String? = null,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()