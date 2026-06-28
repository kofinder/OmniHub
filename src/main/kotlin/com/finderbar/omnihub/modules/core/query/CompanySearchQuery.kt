package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import com.finderbar.omnihub.core.pageable.Order
import com.finderbar.omnihub.core.pageable.Paging
import com.finderbar.omnihub.core.pageable.SearchField

data class CompanySearchQuery(
    val keyword: String? = null,
) : AbstractPageSearchQuery()