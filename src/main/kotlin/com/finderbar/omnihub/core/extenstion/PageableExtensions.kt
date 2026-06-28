package com.finderbar.omnihub.core.extenstion
import org.springframework.data.domain.Page


import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort

fun pageableOf(
    page: Int = 0,
    size: Int = 20,
    sort: String = "id",
    direction: Sort.Direction = Sort.Direction.ASC
): Pageable =
    PageRequest.of(
        page,
        size,
        Sort.by(direction, sort)
    )

