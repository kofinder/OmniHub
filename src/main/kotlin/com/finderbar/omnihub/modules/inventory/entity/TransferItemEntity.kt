package com.finderbar.omnihub.modules.inventory.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "inv_transfer_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_transfer_item",
            columnNames = [
                "transfer_id",
                "line_no"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_transfer_item_transfer",
            columnList = "transfer_id"
        ),
        Index(
            name = "idx_transfer_item_variant",
            columnList = "product_variant_id"
        ),
        Index(
            name = "idx_transfer_item_source_location",
            columnList = "source_location_id"
        ),
        Index(
            name = "idx_transfer_item_destination_location",
            columnList = "destination_location_id"
        )
    ]
)
class TransferItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "transfer_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_transfer_item_transfer")
    )
    var transfer: TransferEntity,

    @Column(
        name = "line_no",
        nullable = false
    )
    var lineNo: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_transfer_item_variant")
    )
    var productVariant: ProductVariantEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "source_location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_transfer_item_source_location")
    )
    var sourceLocation: WarehouseLocationEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "destination_location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_transfer_item_destination_location")
    )
    var destinationLocation: WarehouseLocationEntity,

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
    var transferredQuantity: BigDecimal = BigDecimal.ZERO,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()