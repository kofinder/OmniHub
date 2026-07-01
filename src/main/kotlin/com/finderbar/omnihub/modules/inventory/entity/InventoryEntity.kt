package com.finderbar.omnihub.modules.inventory.entity


import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "inv_inventory",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_inventory",
            columnNames = [
                "warehouse_id",
                "location_id",
                "product_variant_id"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_inventory_wh",
            columnList = "warehouse_id"
        ),
        Index(
            name = "idx_inventory_location",
            columnList = "location_id"
        ),
        Index(
            name = "idx_inventory_variant",
            columnList = "product_variant_id"
        )
    ]
)
class InventoryEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_inventory_warehouse")
    )
    var warehouse: WarehouseEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_inventory_location")
    )
    var location: WarehouseLocationEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_inventory_variant")
    )
    var productVariant: ProductVariantEntity,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var quantity: BigDecimal = BigDecimal.ZERO,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var reservedQuantity: BigDecimal = BigDecimal.ZERO,

    @Column(
        nullable = false,
        precision = 19,
        scale = 4
    )
    var availableQuantity: BigDecimal = BigDecimal.ZERO

) : BaseEntity()