package com.finderbar.omnihub.modules.inventory.entity



import com.finderbar.omnihub.core.entity.BaseEntity
import com.finderbar.omnihub.modules.inventory.constants.StockCountResult
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "inv_stock_count_item",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_stock_count_item",
            columnNames = [
                "stock_count_id",
                "line_no"
            ]
        )
    ],
    indexes = [
        Index(
            name = "idx_stock_count_item_stock_count",
            columnList = "stock_count_id"
        ),
        Index(
            name = "idx_stock_count_item_variant",
            columnList = "product_variant_id"
        ),
        Index(
            name = "idx_stock_count_item_location",
            columnList = "location_id"
        )
    ]
)
class StockCountItemEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "stock_count_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_stock_count_item_stock_count")
    )
    var stockCount: StockCountEntity,

    @Column(
        name = "line_no",
        nullable = false
    )
    var lineNo: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "product_variant_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_stock_count_item_variant")
    )
    var productVariant: ProductVariantEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "location_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_stock_count_item_location")
    )
    var location: WarehouseLocationEntity,

    @Column(
        name = "system_quantity",
        nullable = false,
        precision = 19,
        scale = 4
    )
    var systemQuantity: BigDecimal,

    @Column(
        name = "counted_quantity",
        nullable = false,
        precision = 19,
        scale = 4
    )
    var countedQuantity: BigDecimal,

    @Column(
        name = "variance_quantity",
        nullable = false,
        precision = 19,
        scale = 4
    )
    var varianceQuantity: BigDecimal,

    @Enumerated(EnumType.STRING)
    @Column(
        nullable = false,
        length = 20
    )
    var result: StockCountResult,

    @Column(columnDefinition = "TEXT")
    var remark: String? = null

) : BaseEntity()