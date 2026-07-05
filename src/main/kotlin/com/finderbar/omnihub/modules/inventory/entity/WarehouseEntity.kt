package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.WarehouseType
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize

@Entity
@Table(
    name = "inv_warehouse",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_inv_warehouse_code",
            columnNames = ["code"]
        )
    ],
    indexes = [
        Index(
            name = "idx_inv_warehouse_code",
            columnList = "code"
        ),
        Index(
            name = "idx_inv_warehouse_name",
            columnList = "name"
        ),
        Index(
            name = "idx_inv_warehouse_active",
            columnList = "active"
        )
    ]
)
class WarehouseEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 150)
    var name: String,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    var type: WarehouseType,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(length = 255)
    var address: String? = null,

    @OneToMany(
        mappedBy = "warehouse",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 50)
    var locations: MutableSet<WarehouseLocationEntity> = linkedSetOf(),

    @OneToMany(mappedBy = "warehouse")
    @BatchSize(size = 100)
    var inventories: MutableSet<InventoryEntity> = linkedSetOf()

) : BaseEntity()