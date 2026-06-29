package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root


class BusinessSpecification(
    private val query: BusinessSearchQuery
) : AbstractSearchSpecification<BusinessEntity>() {

    override fun buildPredicates(
        root: Root<BusinessEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}