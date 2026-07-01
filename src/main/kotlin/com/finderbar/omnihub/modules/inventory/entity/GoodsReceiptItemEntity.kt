package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import java.time.LocalDate
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "pur_goods_receipt_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_goods_receipt_item",
            columnNames = [
                "goods_receipt_id",
                "line_no"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_goods_receipt_item_receipt",
            columnList = "goods_receipt_id"
        ),
        Index(
            name = "idx_goods_receipt_item_variant",
            columnList = "product_variant_id"
        ),
        Index(
            name = "idx_goods_receipt_item_location",
            columnList = "location_id"
        )
    ]
)
class GoodsReceiptItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "goods_receipt_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_item_receipt")
    )
    var goodsReceipt: GoodsReceiptEntity,

    @Column(
        name = "line_no",
        nullable = false
    )
    var lineNo: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "purchase_order_item_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_item_po_item")
    )
    var purchaseOrderItem: PurchaseOrderItemEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_item_variant")
    )
    var productVariant: ProductVariantEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_item_location")
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

    @Column(length = 100)
    var lotNumber: String? = null,

    @Column(length = 150)
    var serialNumber: String? = null,

    @Column
    var expiryDate: LocalDate? = null,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()