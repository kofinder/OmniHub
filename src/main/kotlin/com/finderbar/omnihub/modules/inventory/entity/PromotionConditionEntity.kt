package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.PromotionConditionType
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "prc_promotion_condition",
    indexes = [
        Index(name = "idx_prm_condition_promotion", columnList = "promotion_id"),
        Index(name = "idx_prm_condition_sku", columnList = "sku_id"),
        Index(name = "idx_prm_condition_category", columnList = "category_id")
    ]
)
class PromotionConditionEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "promotion_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_condition_promotion")
    )
    var promotion: PromotionEntity,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    var type: PromotionConditionType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku_id")
    var sku: ProductVariantEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    var category: CategoryEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    var brand: BrandEntity? = null,

    @Column(precision = 19, scale = 4)
    var quantity: BigDecimal? = null,

    @Column(precision = 19, scale = 4)
    var amount: BigDecimal? = null

) : BaseEntity()