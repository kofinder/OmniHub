package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "pur_purchase_return_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_purchase_return_item",
            columnNames = [
                "purchase_return_id",
                "line_no"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_purchase_return_item_return",
            columnList = "purchase_return_id"
        ),
        Index(
            name = "idx_purchase_return_item_receipt_item",
            columnList = "goods_receipt_item_id"
        ),
        Index(
            name = "idx_purchase_return_item_variant",
            columnList = "product_variant_id"
        ),
        Index(
            name = "idx_purchase_return_item_location",
            columnList = "location_id"
        )
    ]
)
class PurchaseReturnItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "purchase_return_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_return_item_return")
    )
    var purchaseReturn: PurchaseReturnEntity,

    @Column(
        name = "line_no",
        nullable = false
    )
    var lineNo: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "goods_receipt_item_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_return_item_receipt_item")
    )
    var goodsReceiptItem: GoodsReceiptItemEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_return_item_variant")
    )
    var productVariant: ProductVariantEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_return_item_location")
    )
    var location: WarehouseLocationEntity,

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
    var unitPrice: BigDecimal,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var lineTotal: BigDecimal,

    @Column(columnDefinition = "TEXT")
    var reason: String? = null,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()