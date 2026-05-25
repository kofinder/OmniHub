package com.finderbar.omnihub.modules.iam

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "core",
    name = "branch",
    indexes = [
        Index(
            name = "idx_branch_office_id",
            columnList = "office_id"
        ),
        Index(
            name = "idx_branch_code",
            columnList = "code"
        )
    ]
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