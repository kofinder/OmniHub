package com.finderbar.omnihub.modules.core.specification

import com.finderbar.omnihub.core.specifications.AbstractSearchSpecification
import com.finderbar.omnihub.modules.core.entity.PositionEntity
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import jakarta.persistence.criteria.*


class PositionSpecification(
    private val query: PositionSearchQuery
) : AbstractSearchSpecification<PositionEntity>() {

    override fun buildPredicates(
        root: Root<PositionEntity>,
        cb: CriteriaBuilder
    ): MutableList<Predicate?> {
        TODO("Not yet implemented")
    }
}