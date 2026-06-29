package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root


class EmployeeSpecification(
    private val query: EmployeeSearchQuery
) : AbstractSearchSpecification<EmployeeEntity>() {

    override fun buildPredicates(
        root: Root<EmployeeEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}