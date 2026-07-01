package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.StockAdjustmentStatus
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(
    name = "inv_stock_adjustment",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_inv_stock_adjustment_document_no",
            columnNames = ["document_no"]
        )
    ],
    indexes = [
        Index(
            name = "idx_inv_stock_adjustment_document_no",
            columnList = "document_no"
        ),
        Index(
            name = "idx_inv_stock_adjustment_date",
            columnList = "document_date"
        ),
        Index(
            name = "idx_inv_stock_adjustment_status",
            columnList = "status"
        ),
        Index(
            name = "idx_inv_stock_adjustment_warehouse",
            columnList = "warehouse_id"
        )
    ]
)
class StockAdjustmentEntity(

    @Column(
        name = "document_no",
        nullable = false,
        length = 50
    )
    var documentNo: String,

    @Column(
        name = "document_date",
        nullable = false
    )
    var documentDate: LocalDate,

    @Enumerated(EnumType.STRING)
    @Column(
        nullable = false,
        length = 20
    )
    var status: StockAdjustmentStatus = StockAdjustmentStatus.DRAFT,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_adjustment_warehouse")
    )
    var warehouse: WarehouseEntity,

    @Column(
        length = 255
    )
    var reason: String? = null,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null,

    @Column(name = "approved_by", length = 100)
    var approvedBy: String? = null,

    @Column(name = "approved_at")
    var approvedAt: LocalDateTime? = null,

    @OneToMany(
        mappedBy = "adjustment",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    val items: MutableSet<StockAdjustmentItemEntity> = linkedSetOf()

) : BaseEntity()