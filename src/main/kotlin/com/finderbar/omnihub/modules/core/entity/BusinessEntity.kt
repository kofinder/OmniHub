package com.finderbar.omnihub.modules.core.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

@Entity
@Table(
    name = "core_business",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_business_code",
            columnNames = ["code"]
        )
    ]
)
class BusinessEntity(

    @Column(
        nullable = false,
        unique = true,
        length = 100
    )
    var code: String,

    @Column(
        nullable = false,
        length = 255
    )
    var name: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "branch_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_business_branch"
        )
    )
    var branch: BranchEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "business_type_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_business_business_type"
        )
    )
    var businessType: BusinessTypeEntity,

    @Column(
        name = "registration_no",
        length = 100
    )
    var registrationNo: String? = null,

    @Column(
        name = "tax_id",
        length = 100
    )
    var taxId: String? = null,

    @Column(
        length = 50
    )
    var phone: String? = null,

    @Column(
        length = 255
    )
    var email: String? = null,

    @Column(
        columnDefinition = "TEXT"
    )
    var address: String? = null,

    @Column(
        nullable = false
    )
    var active: Boolean = true

) : BaseEntity()