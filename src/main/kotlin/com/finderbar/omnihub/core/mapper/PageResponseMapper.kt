package com.finderbar.omnihub.core.mapper

import com.finderbar.omnihub.core.api.PageResponse
import org.springframework.data.domain.Page

object PageResponseMapper {
    fun <T : Any> from(
        page: Page<T>
    ): PageResponse<T> {
        return PageResponse(
            content = page.content,
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