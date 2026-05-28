package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "business",
    indexes = [
        Index(
            name = "idx_business_code",
            columnList = "code"
        )
    ]
)
class BusinessEntity(

    @Column(
        name = "name",
        nullable = false,
        length = 255
    )
    var name: String,

    @Column(
        name = "code",
        nullable = false,
        unique = true,
        length = 100
    )
    var code: String,

    @Column(
        name = "phone",
        length = 50
    )
    var phone: String? = null,

    @Column(
        name = "email",
        length = 255
    )
    var email: String? = null,

    @Column(
        name = "address",
        columnDefinition = "TEXT"
    )
    var address: String? = null,

    @Column(
        name = "logo"
    )
    var logo: String? = null,

    @Column(
        name = "active",
        nullable = false
    )
    var active: Boolean = true

) : BaseEntity()