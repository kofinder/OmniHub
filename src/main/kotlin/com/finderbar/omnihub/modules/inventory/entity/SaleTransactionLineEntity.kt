package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    schema = "inventory",
    name = "sale_transaction_line"
)
class SaleTransactionLineEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "sale_transaction_id",
        nullable = false
    )
    var saleTransaction: SaleTransactionEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "item_id",
        nullable = false
    )
    var item: ItemEntity,

    @Column(name = "item_name", nullable = false)
    var itemName: String,

    @Column(name = "item_sku", nullable = false)
    var itemSku: String,

    @Column(
        name = "quantity",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var quantity: BigDecimal,

    @Column(
        name = "unit_price",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var unitPrice: BigDecimal,

    @Column(
        name = "subtotal_amount",
        nullable = false,
        precision = 19,
        scale = 2
    )
    var subtotalAmount: BigDecimal

) : BaseEntity()