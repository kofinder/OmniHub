package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.utility.RefundTransactionStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    schema = "inventory",
    name = "refund_transaction"
)
class RefundTransactionEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "sale_transaction_id",
        nullable = false
    )
    var saleTransaction: SaleTransactionEntity,

    @Column(
        name = "refund_no",
        nullable = false,
        unique = true
    )
    var refundNo: String,

    @Column(
        name = "refund_amount",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var refundAmount: BigDecimal,

    @Enumerated(EnumType.STRING)
    @Column(
        name = "status",
        nullable = false
    )
    var status: RefundTransactionStatus,

    @Column(
        name = "reason",
        columnDefinition = "TEXT"
    )
    var reason: String? = null

) : BaseEntity()