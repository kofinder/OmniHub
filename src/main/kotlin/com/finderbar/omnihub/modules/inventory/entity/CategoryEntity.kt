package com.finderbar.omnihub.modules.inventory.entity

import com.finderbar.omnihub.core.entity.BaseEntity
import jakarta.persistence.*
import org.hibernate.annotations.BatchSize


@Entity
@Table(
    name = "inv_category",
    uniqueConstraints = [
        UniqueConstraint(name = "uk_inv_category_code", columnNames = ["code"])
    ],
    indexes = [
        Index(name = "idx_inv_category_parent", columnList = "parent_id"),
        Index(name = "idx_inv_category_code", columnList = "code"),
        Index(name = "idx_inv_category_level", columnList = "level"),
        Index(name = "idx_inv_category_active", columnList = "active")
    ]
)
class CategoryEntity(

    @Column(nullable = false, length = 50)
    var code: String,

    @Column(nullable = false, length = 150)
    var name: String,

    @Column(columnDefinition = "TEXT")
    var thumbnail: String? = null,

    @Column(columnDefinition = "TEXT")
    var description: String? = null,

    @Column(nullable = false)
    var level: Int = 1,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "parent_id",
        foreignKey = ForeignKey(name = "fk_category_parent")
    )
    var parent: CategoryEntity? = null,

    @OneToMany(mappedBy = "parent")
    @BatchSize(size = 50)
    val children: MutableSet<CategoryEntity> = linkedSetOf(),

    @OneToMany(mappedBy = "category")
    @BatchSize(size = 50)
    val products: MutableSet<ProductEntity> = linkedSetOf()

) : BaseEntity()