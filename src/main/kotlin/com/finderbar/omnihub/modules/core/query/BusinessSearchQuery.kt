package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Business Search Criteria")
data class BusinessSearchQuery(
    @Schema(
        description = "Search keyword (code, name, phone, email)",
        example = "ABC"
    )
    val keyword: String? = null,
) : AbstractPageSearchQuery()