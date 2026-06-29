package com.finderbar.omnihub.modules.core.query

import com.finderbar.omnihub.core.pageable.AbstractPageSearchQuery
import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "Employee Search Criteria")
data class EmployeeSearchQuery(

    @Schema(
        description = "Search keyword (employee number, first name, last name, phone, email)",
        example = "John"
    )
    val keyword: String? = null,

    ) : AbstractPageSearchQuery()