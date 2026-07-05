package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.BatchSize

@Entity
@Table(
    name = "inv_product",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_inv_product_code", columnNames = ["code"])
    ],
    indexes = [
        Index(name = "idx_inv_product_brand", columnList = "brand_id"),
        Index(name = "idx_inv_product_category", columnList = "category_id"),
        Index(name = "idx_inv_product_active", columnList = "active")
    ]
)
class ProductEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 200)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(columnDefinition = "TEXT")
    var thumbnail: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "brand_id",
        foreignKey = ForeignKey(name = "fk_product_brand")
    )
    var brand: BrandEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "category_id",
        foreignKey = ForeignKey(name = "fk_product_category")
    )
    var category: CategoryEntity,

    @OneToMany(
        mappedBy = "product",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 50)
    var variants: MutableSet<ProductVariantEntity> = linkedSetOf()

) : BaseEntity()