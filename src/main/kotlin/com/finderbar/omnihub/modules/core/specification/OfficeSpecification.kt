package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root


class OfficeSpecification(
    private val query: OfficeSearchQuery
) : AbstractSearchSpecification<OfficeEntity>() {

    override fun buildPredicates(
        root: Root<OfficeEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}