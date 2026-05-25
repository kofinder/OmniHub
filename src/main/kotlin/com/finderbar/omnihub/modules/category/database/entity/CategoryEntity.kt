package com.finderbar.omnihub.modules.category.database.entity

import com.finderbar.omnihub.core.BaseEntity
import jakarta.persistence.*
import java.util.UUID

@Entity
@Table(
    schema = "inventory",
    name = "category"
)
class CategoryEntity(

    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "code", nullable = false, unique = true)
    var code: String,

    @Column(name = "thumb")
    var thumb: String? = null,

    @Column(name = "description")
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    var parent: CategoryEntity? = null,

    @Column(name = "business_id", nullable = false)
    var businessId: UUID

) : BaseEntity()