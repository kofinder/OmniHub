package com.finderbar.omnihub.core.pageable


abstract class AbstractPageSearchQuery(

    open val search: List<SearchField> = emptyList(),

    open val order: Order = Order(),

    open val paging: Paging = Paging()

)