package com.finderbar.omnihub.modules.core.entity
import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(
    schema = "core",
    name = "branch"
)
class BranchEntity(

    @Column(
        nullable = false,
        length = 255
    )
    var name: String,

    @Column(
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

    @Column(length = 50)
    var phone: String? = null,

    @Column(length = 255)
    var email: String? = null,

    @Column(columnDefinition = "TEXT")
    var address: String? = null,

    @Column(nullable = false)
    var active: Boolean = true

) : BaseEntity()