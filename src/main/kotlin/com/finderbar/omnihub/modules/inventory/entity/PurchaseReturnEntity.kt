package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.PurchaseReturnStatus
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(
    name = "pur_purchase_return",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_purchase_return_document_no",
            columnNames = ["document_no"]
        )
    ],
    indexes = [
        Index(
            name = "idx_purchase_return_document_no",
            columnList = "document_no"
        ),
        Index(
            name = "idx_purchase_return_document_date",
            columnList = "document_date"
        ),
        Index(
            name = "idx_purchase_return_vendor",
            columnList = "vendor_id"
        ),
        Index(
            name = "idx_purchase_return_goods_receipt",
            columnList = "goods_receipt_id"
        ),
        Index(
            name = "idx_purchase_return_status",
            columnList = "status"
        )
    ]
)
class PurchaseReturnEntity(

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
        foreignKey = ForeignKey(name = "fk_purchase_return_vendor")
    )
    var vendor: VendorEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "goods_receipt_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_return_goods_receipt")
    )
    var goodsReceipt: GoodsReceiptEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_purchase_return_warehouse")
    )
    var warehouse: WarehouseEntity,

    @Enumerated(EnumType.STRING)
    @Column(
        nullable = false,
        length = 30
    )
    var status: PurchaseReturnStatus = PurchaseReturnStatus.DRAFT,

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
    var reason: String? = null,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null,

    @OneToMany(
        mappedBy = "purchaseReturn",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    val items: MutableSet<PurchaseReturnItemEntity> = linkedSetOf()

) : BaseEntity()