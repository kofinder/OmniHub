package com.finderbar.omnihub.modules.inventory.entity


import com.finderbar.omnihub.modules.inventory.constants.TransferStatus
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize
import java.time.LocalDate

@Entity
@Table(
    name = "inv_transfer",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_inv_transfer_document_no",
            columnNames = ["document_no"]
        )
    ],
    indexes = [
        Index(
            name = "idx_inv_transfer_document_no",
            columnList = "document_no"
        ),
        Index(
            name = "idx_inv_transfer_date",
            columnList = "document_date"
        ),
        Index(
            name = "idx_inv_transfer_status",
            columnList = "status"
        ),
        Index(
            name = "idx_inv_transfer_from_wh",
            columnList = "source_warehouse_id"
        ),
        Index(
            name = "idx_inv_transfer_to_wh",
            columnList = "destination_warehouse_id"
        )
    ]
)
class TransferEntity(

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
    var status: TransferStatus = TransferStatus.DRAFT,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "source_warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_transfer_source_warehouse")
    )
    var sourceWarehouse: WarehouseEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "destination_warehouse_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_transfer_destination_warehouse")
    )
    var destinationWarehouse: WarehouseEntity,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null,

    @OneToMany(
        mappedBy = "transfer",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    @BatchSize(size = 100)
    val items: MutableSet<TransferItemEntity> = linkedSetOf()

) : BaseEntity()