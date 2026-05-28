package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.BaseEntity
import com.finderbar.omnihub.modules.inventory.utility.ReceiptStatus
import jakarta.persistence.*

@Entity
@Table(
    schema = "inventory",
    name = "receipt"
)
class ReceiptEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "sale_transaction_id",
        nullable = false
    )
    var saleTransaction: SaleTransactionEntity,

    @Enumerated(EnumType.STRING)
    @Column(
        name = "status",
        nullable = false
    )
    var status: ReceiptStatus,

    @Column(name = "printer_name")
    var printerName: String? = null,

    @Column(
        name = "receipt_content",
        columnDefinition = "TEXT"
    )
    var receiptContent: String? = null

) : BaseEntity()