package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize

@Entity
@Table(
    name = "inv_warehouse_location",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_wh_location",
            columnNames = [
                "warehouse_id",
                "code"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_wh_location_wh",
            columnList = "warehouse_id"
        ),
        Index(
            name = "idx_wh_location_code",
            columnList = "code"
        )
    ]
)
class WarehouseLocationEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 150)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_location_warehouse")
    )
    var warehouse: WarehouseEntity,

    @OneToMany(mappedBy = "location")
    @BatchSize(size = 100)
    var inventories: MutableSet<InventoryEntity> = linkedSetOf()

) : BaseEntity()