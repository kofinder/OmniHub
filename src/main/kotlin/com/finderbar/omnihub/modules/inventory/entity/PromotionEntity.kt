package com.finderbar.omnihub.modules.inventory.entity



import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.LocalDate

@Entity
@Table(
    name = "prc_promotion",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_prc_promotion_code",
            columnNames = ["code"]
        )
    ],
    indexes = [
        Index(name = "idx_prc_promotion_code", columnList = "code"),
        Index(name = "idx_prc_promotion_active", columnList = "active"),
        Index(name = "idx_prc_promotion_date", columnList = "start_date,end_date")
    ]
)
class PromotionEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 150)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(name = "start_date")
    var startDate: LocalDate? = null,

    @Column(name = "end_date")
    var endDate: LocalDate? = null,

    @Column(nullable = false)
    var priority: Int = 0,

    @Column(nullable = false)
    var stackable: Boolean = false,

    @OneToMany(
        mappedBy = "promotion",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    val conditions: MutableSet<PromotionConditionEntity> = linkedSetOf(),

    @OneToMany(
        mappedBy = "promotion",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    val rewards: MutableSet<PromotionRewardEntity> = linkedSetOf()

) : BaseEntity()