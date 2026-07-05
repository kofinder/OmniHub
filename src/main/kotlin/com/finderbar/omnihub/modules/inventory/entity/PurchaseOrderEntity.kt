package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.PurchaseOrderStatus
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.math.BigDecimal
import java.time.LocalDate

@Entity
@Table(
    name = "pur_purchase_order",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_purchase_order_document_no",
            columnNames = ["document_no"]
        )
    ],
    indexes = [
        Index(
            name = "idx_purchase_order_document_no",
            columnList = "document_no"
        ),
        Index(
            name = "idx_purchase_order_date",
            columnList = "document_date"
        ),
        Index(
            name = "idx_purchase_order_vendor",
            columnList = "vendor_id"
        ),
        Index(
            name = "idx_purchase_order_status",
            columnList = "status"
        )
    ]
)
class PurchaseOrderEntity(

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
        foreignKey = ForeignKey(name = "fk_purchase_order_vendor")
    )
    var vendor: VendorEntity,

    @Enumerated(EnumType.STRING)
    @Column(
        nullable = false,
        length = 30
    )
    var status: PurchaseOrderStatus = PurchaseOrderStatus.DRAFT,

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
        mappedBy = "purchaseOrder",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    var items: MutableSet<PurchaseOrderItemEntity> = linkedSetOf()

) : BaseEntity()