package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.BranchEntity
import com.finderbar.omnihub.modules.core.query.BranchSearchQuery
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root


class BranchSpecification(
    private val query: BranchSearchQuery
) : AbstractSearchSpecification<BranchEntity>() {

    override fun buildPredicates(
        root: Root<BranchEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}