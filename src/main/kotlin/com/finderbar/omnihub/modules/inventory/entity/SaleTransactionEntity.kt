package com.finderbar.omnihub.modules.inventory.entity


import com.finderbar.omnihub.core.BaseEntity
import com.finderbar.omnihub.modules.inventory.utility.SaleTransactionStatus
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    schema = "inventory",
    name = "sale_transaction",
    indexes = [
//        Index(name = "idx_sale_transaction_business_id", columnList = "business_id"),
//        Index(name = "idx_sale_transaction_branch_id", columnList = "branch_id"),
        Index(name = "idx_sale_transaction_invoice_no", columnList = "invoice_no")
    ]
)
class SaleTransactionEntity(

    @Column(name = "invoice_no", nullable = false, unique = true)
    var invoiceNo: String,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "business_id",
//        nullable = false,
//        foreignKey = ForeignKey(name = "fk_sale_transaction_business")
//    )
//    var business: BusinessEntity,

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "branch_id",
//        nullable = false,
//        foreignKey = ForeignKey(name = "fk_sale_transaction_branch")
//    )
//    var branch: BranchEntity,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "cashier_id",
//        foreignKey = ForeignKey(name = "fk_sale_transaction_cashier")
//    )
//    var cashier: UserEntity? = null,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "customer_id",
//        foreignKey = ForeignKey(name = "fk_sale_transaction_customer")
//    )
//    var customer: CustomerEntity? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    var status: SaleTransactionStatus,

    @Column(
        name = "subtotal_amount",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var subtotalAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        name = "discount_amount",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var discountAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        name = "tax_amount",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var taxAmount: BigDecimal = BigDecimal.ZERO,

    @Column(
        name = "total_amount",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var totalAmount: BigDecimal = BigDecimal.ZERO,

    @Column(name = "remark", columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()