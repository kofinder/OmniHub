package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize

@Entity
@Table(
    name = "pur_vendor",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_vendor_code",
            columnNames = ["code"]
        ),
        UniqueConstraint(
            name = "uk_vendor_name",
            columnNames = ["name"]
        )
    ],
    indexes = [
        Index(
            name = "idx_vendor_code",
            columnList = "code"
        ),
        Index(
            name = "idx_vendor_name",
            columnList = "name"
        ),
        Index(
            name = "idx_vendor_active",
            columnList = "active"
        )
    ]
)
class VendorEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 255)
    var name: String,

    @Column(length = 100)
    var phone: String? = null,

    @Column(length = 255)
    var email: String? = null,

    @Column(length = 255)
    var website: String? = null,

    @Column(length = 100)
    var taxNumber: String? = null,

    @Column(columnDefinition = "TEXT")
    var address: String? = null,

    @Column(nullable = false)
    var active: Boolean = true,

    @OneToMany(
        mappedBy = "vendor",
        fetch = FetchType.LAZY
    )
    @BatchSize(size = 50)
    var purchaseOrders: MutableSet<PurchaseOrderEntity> = linkedSetOf()

) : BaseEntity()