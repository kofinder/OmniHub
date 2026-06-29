package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Branch Search Criteria")
data class BranchSearchQuery(

    @Schema(
        description = "Search keyword (code, name, phone, email, tax ID)",
        example = "Bangkok"
    )
    val keyword: String? = null,

    ) : AbstractPageSearchQuery()