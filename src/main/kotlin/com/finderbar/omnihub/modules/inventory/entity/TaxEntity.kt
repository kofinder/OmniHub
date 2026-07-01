package com.finderbar.omnihub.modules.inventory.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import java.math.BigDecimal

@Entity
@Table(
    name = "prc_tax",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_prc_tax_code",
            columnNames = ["code"]
        )
    ],
    indexes = [
        Index(name = "idx_prc_tax_code", columnList = "code"),
        Index(name = "idx_prc_tax_active", columnList = "active")
    ]
)
class TaxEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 150)
    var name: String,

    @Column(
        nullable = false,
        precision = 7,
        scale = 4
    )
    var rate: BigDecimal,

    @Column(nullable = false)
    var inclusive: Boolean = false

) : BaseEntity()