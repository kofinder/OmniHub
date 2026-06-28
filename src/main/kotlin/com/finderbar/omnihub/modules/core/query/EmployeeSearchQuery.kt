package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery


data class EmployeeSearchQuery(
    val keyword: String? = null,
) : AbstractPageSearchQuery()