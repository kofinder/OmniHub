package com.finderbar.omnihub.modules.iam.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "branch"
)
class BranchEntity(

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "office_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_branch_office"
        )
    )
    var office: OfficeEntity,

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
        name = "active",
        nullable = false
    )
    var active: Boolean = true

) : BaseEntity()