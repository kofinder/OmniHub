package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize

@Entity
@Table(
    name = "inv_brand",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_inv_brand_code", columnNames = ["code"]),
        UniqueConstraint(name = "uk_inv_brand_name", columnNames = ["name"])
    ],
    indexes = [
        Index(name = "idx_inv_brand_code", columnList = "code"),
        Index(name = "idx_inv_brand_name", columnList = "name"),
        Index(name = "idx_inv_brand_active", columnList = "active")
    ]
)
class BrandEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 150)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var logo: String? = null,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    @BatchSize(size = 50)
    val products: MutableSet<ProductEntity> = linkedSetOf()

) : BaseEntity()