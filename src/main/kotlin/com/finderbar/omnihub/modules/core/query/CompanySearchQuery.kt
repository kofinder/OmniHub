package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Company Search Criteria")
data class CompanySearchQuery(

    @Schema(
        description = "Search keyword (code, name, tax ID, phone, email)",
        example = "ABC"
    )
    val keyword: String? = null,

) : AbstractPageSearchQuery()