package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import com.finderbar.omnihub.modules.core.query.CompanySearchQuery
import jakarta.persistence.criteria.*


class CompanySpecification(
    private val query: CompanySearchQuery
) : AbstractSearchSpecification<CompanyEntity>() {

    override fun buildPredicates(
        root: Root<CompanyEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}