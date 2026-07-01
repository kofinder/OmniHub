package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.MovementType
import com.finderbar.omnihub.modules.inventory.constants.ReferenceType
import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(
    name = "inv_stock_movement",
    indexes = [

        Index(
            name = "idx_stock_movement_variant",
            columnList = "product_variant_id"
        ),

        Index(
            name = "idx_stock_movement_warehouse",
            columnList = "warehouse_id"
        ),

        Index(
            name = "idx_stock_movement_location",
            columnList = "location_id"
        ),

        Index(
            name = "idx_stock_movement_date",
            columnList = "movement_date"
        ),

        Index(
            name = "idx_stock_movement_reference",
            columnList = "reference_type,reference_id"
        )
    ]
)
class StockMovementEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_stock_movement_warehouse")
    )
    var warehouse: WarehouseEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_stock_movement_location")
    )
    var location: WarehouseLocationEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_stock_movement_variant")
    )
    var productVariant: ProductVariantEntity,

    @Enumerated(EnumType.STRING)
    @Column(
        name = "movement_type",
        nullable = false,
        length = 30
    )
    var movementType: MovementType,

    @Enumerated(EnumType.STRING)
    @Column(
        name = "reference_type",
        nullable = false,
        length = 30
    )
    var referenceType: ReferenceType,

    @Column(
        name = "reference_id",
        nullable = false
    )
    var referenceId: Long,

    @Column(
        name = "movement_date",
        nullable = false
    )
    var movementDate: LocalDateTime,

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
    var balanceAfter: BigDecimal,

    @Column(
        precision = 19,
        scale = 4
    )
    var unitCost: BigDecimal? = null,

    @Column(
        precision = 19,
        scale = 4
    )
    var totalCost: BigDecimal? = null,

    @Column(
        length = 100
    )
    var referenceNo: String? = null,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()