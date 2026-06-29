package com.finderbar.omnihub.core.pageable

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(description = "Search filter")
data class SearchField(

    @field:NotBlank
    @Schema(
        description = "Entity field",
        example = "name"
    )
    val name: String,

    @Schema(
        description = "Search value",
        example = "ABC Trading"
    )
    val value: String?
)