package com.finderbar.omnihub.modules.iam.entity
import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "authority",
    indexes = [
        Index(
            name = "idx_authority_name",
            columnList = "name",
            unique = true
        )
    ]
)
class AuthorityEntity(

    @Column(
        name = "name",
        nullable = false,
        unique = true,
        length = 100
    )
    var name: String,

    @Column(
        name = "description",
        columnDefinition = "TEXT"
    )
    var description: String? = null

) : BaseEntity()