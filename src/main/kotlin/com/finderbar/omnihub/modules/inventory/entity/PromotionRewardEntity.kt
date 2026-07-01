package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.PromotionRewardType
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "prc_promotion_reward",
    indexes = [
        Index(name = "idx_prm_reward_promotion", columnList = "promotion_id")
    ]
)
class PromotionRewardEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "promotion_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_reward_promotion")
    )
    var promotion: PromotionEntity,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    var type: PromotionRewardType,

    @Column(precision = 19, scale = 4)
    var discountPercent: BigDecimal? = null,

    @Column(precision = 19, scale = 4)
    var discountAmount: BigDecimal? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "free_sku_id")
    var freeSku: ProductVariantEntity? = null,

    @Column(precision = 19, scale = 4)
    var freeQuantity: BigDecimal? = null

) : BaseEntity()