package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Index
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import org.hibernate.annotations.BatchSize
import java.time.LocalDate

@Entity
@Table(
    name = "prc_price_list",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_prc_price_list_code",
            columnNames = ["code"]
        )
    ],
    indexes = [
        Index(
            name = "idx_prc_price_list_code",
            columnList = "code"
        ),
        Index(
            name = "idx_prc_price_list_active",
            columnList = "active"
        ),
        Index(
            name = "idx_prc_price_list_start_date",
            columnList = "start_date"
        ),
        Index(
            name = "idx_prc_price_list_end_date",
            columnList = "end_date"
        )
    ]
)
class PriceListEntity(

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

    @OneToMany(
        mappedBy = "priceList",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    var items: MutableSet<PriceListItemEntity> = linkedSetOf()

) : BaseEntity()