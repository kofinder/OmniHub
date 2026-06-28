package com.finderbar.omnihub.core.mapper

import com.finderbar.omnihub.core.api.PageResponse
import org.springframework.data.domain.Page

object PageMapper {

    fun <E : Any, M : Any> from(
        page: Page<E>,
        transform: (E) -> M
    ): PageResponse<M> {
        return PageResponse(
            content = page.content.map(transform),
            page = page.number,
            size = page.size,
            totalElements = page.totalElements,
            totalPages = page.totalPages,
            first = page.isFirst,
            last = page.isLast,
            hasNext = page.hasNext(),
            hasPrevious = page.hasPrevious()
        )
    }
}