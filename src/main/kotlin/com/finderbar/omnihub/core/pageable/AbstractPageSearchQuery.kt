package com.finderbar.omnihub.core.pageable

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.Valid

@Schema(description = "Base search request with filtering, sorting and pagination")
abstract class AbstractPageSearchQuery(

    @field:Valid
    @Schema(description = "Dynamic search filters")
    open val search: List<SearchField> = emptyList(),

    @field:Valid
    @Schema(description = "Sorting options")
    open val order: Order = Order(),

    @field:Valid
    @Schema(description = "Pagination")
    open val paging: Paging = Paging()
)