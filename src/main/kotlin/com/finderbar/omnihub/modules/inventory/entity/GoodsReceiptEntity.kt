package com.finderbar.omnihub.modules.inventory.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.GoodsReceiptStatus
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(
    name = "pur_goods_receipt",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_goods_receipt_document_no",
            columnNames = ["document_no"]
        )
    ],
    indexes = [
        Index(
            name = "idx_goods_receipt_document_no",
            columnList = "document_no"
        ),
        Index(
            name = "idx_goods_receipt_date",
            columnList = "document_date"
        ),
        Index(
            name = "idx_goods_receipt_vendor",
            columnList = "vendor_id"
        ),
        Index(
            name = "idx_goods_receipt_po",
            columnList = "purchase_order_id"
        ),
        Index(
            name = "idx_goods_receipt_status",
            columnList = "status"
        )
    ]
)
class GoodsReceiptEntity(

    @Column(
        name = "document_no",
        nullable = false,
        length = 50
    )
    var documentNo: String,

    @Column(
        name = "document_date",
        nullable = false
    )
    var documentDate: LocalDate,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "vendor_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_vendor")
    )
    var vendor: VendorEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "purchase_order_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_purchase_order")
    )
    var purchaseOrder: PurchaseOrderEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_goods_receipt_warehouse")
    )
    var warehouse: WarehouseEntity,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    var status: GoodsReceiptStatus = GoodsReceiptStatus.DRAFT,

    @Column(length = 100)
    var supplierInvoiceNo: String? = null,

    @Column(
        precision = 19,
        scale = 4,
        nullable = false
    )
    var subtotal: BigDecimal = BigDecimal.ZERO,

    @Column(
        precision = 19,
        scale = 4,
        nullable = false
    )
    var discountAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        precision = 19,
        scale = 4,
        nullable = false
    )
    var taxAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        precision = 19,
        scale = 4,
        nullable = false
    )
    var totalAmount: BigDecimal = BigDecimal.ZERO,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null,

    @OneToMany(
        mappedBy = "goodsReceipt",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    val items: MutableSet<GoodsReceiptItemEntity> = linkedSetOf()

) : BaseEntity()