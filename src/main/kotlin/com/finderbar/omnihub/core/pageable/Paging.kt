package com.finderbar.omnihub.core.pageable

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min

@Schema(description = "Pagination configuration")
data class Paging(

    @field:Min(1)
    @field:Max(500)
    @Schema(
        description = "Number of records per page",
        example = "20",
        defaultValue = "10",
        minimum = "1",
        maximum = "500"
    )
    val rowPerPage: Int = 10,

    @field:Min(0)
    @Schema(
        description = "Page number (starting at 0)",
        example = "0",
        defaultValue = "0"
    )
    val skipPerPage: Int = 0,

    @field:Min(0)
    @Schema(
        description = "Offset from first record",
        example = "0",
        defaultValue = "0"
    )
    val offset: Int = 0
)