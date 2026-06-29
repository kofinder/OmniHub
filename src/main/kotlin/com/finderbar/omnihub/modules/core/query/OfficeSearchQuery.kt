package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Office Search Criteria")
data class OfficeSearchQuery(

    @Schema(
        description = "Search keyword (code, name, phone, email)",
        example = "Bangkok Head Office"
    )
    val keyword: String? = null,

) : AbstractPageSearchQuery()