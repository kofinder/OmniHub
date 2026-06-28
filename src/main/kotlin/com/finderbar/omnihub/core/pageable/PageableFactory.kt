package com.finderbar.omnihub.core.pageable

import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

object PageableFactory {
    fun create(query: AbstractPageSearchQuery): Pageable {
        return PageRequest.of(
            query.paging.offset,
            query.paging.rowPerPage,
            Sort.by(
                Sort.Direction.valueOf(query.order.direction.name),
                query.order.name
            )
        )
    }
}