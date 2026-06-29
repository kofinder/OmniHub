package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.DepartmentEntity
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root


class DepartmentSpecification(
    private val query: DepartmentSearchQuery
) : AbstractSearchSpecification<DepartmentEntity>() {

    override fun buildPredicates(
        root: Root<DepartmentEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}