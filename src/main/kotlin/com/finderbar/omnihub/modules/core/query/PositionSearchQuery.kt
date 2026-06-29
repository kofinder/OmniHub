package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema
@Schema(description = "Position Search Criteria")
data class PositionSearchQuery(
    @Schema(
        description = "Search keyword (code, name, description)",
        example = "Software Engineer"
    )
    val keyword: String? = null,
) : AbstractPageSearchQuery()