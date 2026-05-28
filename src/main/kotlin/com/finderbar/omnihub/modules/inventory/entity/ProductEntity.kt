package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.math.BigDecimal
import java.util.UUID

@Entity
@Table(
    schema = "inventory",
    name = "product",
    indexes = [
//        Index(name = "idx_product_business_id", columnList = "business_id"),
        Index(name = "idx_product_category_id", columnList = "category_id"),
        Index(name = "idx_product_sku", columnList = "sku_name"),
        Index(name = "idx_product_barcode", columnList = "barcode")
    ]
)
class ProductEntity(

    @Column(name = "barcode", unique = true, length = 100)
    var barcode: String? = null,

    @Column(name = "sku_name", nullable = false, unique = true, length = 100)
    var skuName: String,

    @Column(name = "package_type", nullable = false)
    var packageType: String,

    @Column(name = "brand_name", nullable = true, length = 100)
    var brandName: String ? = null,

    @Column(name = "variant", nullable = true, length = 100)
    var variant: String ? = null,

    @Column(name = "size_info", nullable = true, length = 100)
    var sizeInfo: String ? = null,

    @Column(name = "manufacturer", nullable = true, length = 100)
    var manufacturer: String ? = null,

    @Column(name = "additional_info", columnDefinition = "TEXT")
    var additionalInfo: String? = null,

    @Column(name = "thumbnail", nullable = true,)
    var thumbnail: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "category_id",
        foreignKey = ForeignKey(name = "fk_product_category")
    )
    var category: CategoryEntity? = null

) : BaseEntity()