package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Department Search Criteria")
data class DepartmentSearchQuery(
    @Schema(
        description = "Search keyword (code, name, description)",
        example = "Information Technology"
    )
    val keyword: String? = null,

) : AbstractPageSearchQuery()