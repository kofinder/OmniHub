package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "office"
)
class OfficeEntity(

    @Column(
        name = "name",
        nullable = false
    )
    var name: String,

    @Column(
        name = "code",
        nullable = false,
        unique = true
    )
    var code: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "business_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_office_business"
        )
    )
    var business: BusinessEntity,

    @Column(name = "phone")
    var phone: String? = null,

    @Column(name = "email")
    var email: String? = null,

    @Column(
        name = "address",
        columnDefinition = "TEXT"
    )
    var address: String? = null,

    @Column(
        name = "active",
        nullable = false
    )
    var active: Boolean = true
) : BaseEntity()