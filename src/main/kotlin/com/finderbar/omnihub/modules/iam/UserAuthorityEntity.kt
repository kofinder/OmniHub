package com.finderbar.omnihub.modules.iam

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "user_authority",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_user_authority",
            columnNames = [
                "user_id",
                "authority_id"
            ]
        )
    ]
)
class UserAuthorityEntity(

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "user_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_user_authority_user"
        )
    )
    var user: UserEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "authority_id",
        nullable = false,
        foreignKey = ForeignKey(
            name = "fk_user_authority_authority"
        )
    )
    var authority: AuthorityEntity

) : BaseEntity()