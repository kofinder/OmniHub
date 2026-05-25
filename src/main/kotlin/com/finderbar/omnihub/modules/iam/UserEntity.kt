package com.finderbar.omnihub.modules.iam

import com.finderbar.omnihub.core.BaseEntity
import com.finderbar.omnihub.modules.business.BusinessEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

package com.finderbar.omnihub.modules.iam.database.entity

import com.finderbar.omnihub.core.BaseEntity
import com.finderbar.omnihub.modules.branch.database.entity.BranchEntity
import com.finderbar.omnihub.modules.office.database.entity.OfficeEntity
import jakarta.persistence.*

@Entity
@Table(
    schema = "iam",
    name = "users",
    indexes = [
        Index(
            name = "idx_user_username",
            columnList = "username",
            unique = true
        )
    ]
)
class UserEntity(

    @Column(
        name = "username",
        nullable = false,
        unique = true
    )
    var username: String,

    @Column(
        name = "password",
        nullable = false
    )
    var password: String,

    @Column(
        name = "email",
        nullable = false,
        unique = true
    )
    var email: String,

    @Column(
        name = "enabled",
        nullable = false
    )
    var enabled: Boolean = true,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "office_id",
        foreignKey = ForeignKey(
            name = "fk_user_office"
        )
    )
    var office: OfficeEntity? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "branch_id",
        foreignKey = ForeignKey(
            name = "fk_user_branch"
        )
    )
    var branch: BranchEntity? = null,

    @OneToMany(
        mappedBy = "user",
        cascade = [CascadeType.ALL],
        orphanRemoval = true
    )
    var authorities: MutableSet<UserAuthorityEntity> = mutableSetOf(),


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        schema = "iam",
        name = "user_role",
        joinColumns = [
            JoinColumn(name = "user_id")
        ],
        inverseJoinColumns = [
            JoinColumn(name = "role_id")
        ]
    )
    var roles: MutableSet<RoleEntity> = mutableSetOf()

) : BaseEntity()

//@Entity
//@Table(
//    schema = "iam",
//    name = "user_account",
//    indexes = [
//        Index(
//            name = "idx_user_username",
//            columnList = "username"
//        ),
//        Index(
//            name = "idx_user_email",
//            columnList = "email"
//        ),
//        Index(
//            name = "idx_user_business_id",
//            columnList = "business_id"
//        ),
//        Index(
//            name = "idx_user_office_id",
//            columnList = "office_id"
//        ),
//        Index(
//            name = "idx_user_branch_id",
//            columnList = "branch_id"
//        )
//    ]
//)
//class UserEntity(
//
//    @Column(
//        name = "username",
//        nullable = false,
//        unique = true,
//        length = 100
//    )
//    var username: String,
//
//    @Column(
//        name = "password",
//        nullable = false
//    )
//    var password: String,
//
//    @Column(
//        name = "full_name",
//        nullable = false,
//        length = 255
//    )
//    var fullName: String,
//
//    @Column(
//        name = "email",
//        unique = true,
//        length = 255
//    )
//    var email: String? = null,
//
//    @Column(
//        name = "phone",
//        length = 50
//    )
//    var phone: String? = null,
//
//    @Enumerated(EnumType.STRING)
//    @Column(
//        name = "status",
//        nullable = false,
//        length = 50
//    )
//    var status: UserStatus = UserStatus.ACTIVE,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "business_id",
//        foreignKey = ForeignKey(
//            name = "fk_user_business"
//        )
//    )
//    var business: BusinessEntity? = null,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "office_id",
//        foreignKey = ForeignKey(
//            name = "fk_user_office"
//        )
//    )
//    var office: OfficeEntity? = null,
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(
//        name = "branch_id",
//        foreignKey = ForeignKey(
//            name = "fk_user_branch"
//        )
//    )
//    var branch: BranchEntity? = null,
//
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//        schema = "iam",
//        name = "user_role",
//        joinColumns = [
//            JoinColumn(name = "user_id")
//        ],
//        inverseJoinColumns = [
//            JoinColumn(name = "role_id")
//        ]
//    )
//    var roles: MutableSet<RoleEntity> = mutableSetOf()
//
//) : BaseEntity()