package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "pur_purchase_order_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_purchase_order_item",
            columnNames = [
                "purchase_order_id",
                "line_no"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_purchase_order_item_po",
            columnList = "purchase_order_id"
        ),
        Index(
            name = "idx_purchase_order_item_variant",
            columnList = "product_variant_id"
        ),
        Index(
            name = "idx_purchase_order_item_warehouse",
            columnList = "warehouse_id"
        )
    ]
)
class PurchaseOrderItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "purchase_order_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_order_item_po")
    )
    var purchaseOrder: PurchaseOrderEntity,

    @Column(
        name = "line_no",
        nullable = false
    )
    var lineNo: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_order_item_variant")
    )
    var productVariant: ProductVariantEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_order_item_warehouse")
    )
    var warehouse: WarehouseEntity,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var quantity: BigDecimal,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var receivedQuantity: BigDecimal = BigDecimal.ZERO,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var unitPrice: BigDecimal,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var discountAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var taxAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var lineTotal: BigDecimal,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()