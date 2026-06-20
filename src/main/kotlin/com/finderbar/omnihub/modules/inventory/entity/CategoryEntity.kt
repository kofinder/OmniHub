package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.ForeignKey
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(
    schema = "inventory",
    name = "category",
    indexes = [
//        Index(name = "idx_category_business_id", columnList = "business_id"),
        Index(name = "idx_category_parent_id", columnList = "parent_id"),
        Index(name = "idx_category_code", columnList = "code")
    ]
)
class CategoryEntity(

    @Column(name = "name", nullable = false, length = 255)
    var name: String,

    @Column(name = "code", nullable = false, length = 100)
    var code: String,

    @Column(name = "thumbnail")
    var thumbnail: String? = null,

    @Column(name = "description", columnDefinition = "TEXT")
    var description: String? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "parent_id",
        foreignKey = ForeignKey(name = "fk_category_parent")
    )
    var parent: CategoryEntity? = null

) : BaseEntity()