package com.finderbar.omnihub.core.pageable

data class Paging(
    val rowPerPage: Int = 10,

    val skipPerPage: Int = 0,

    val offset: Int = 0
)