package com.finderbar.omnihub.core.pageable

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Sorting configuration")
data class Order(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Property to sort by",
        example = "createdAt",
        defaultValue = "createdAt"
    )
    val name: String = "createdAt",

    @Schema(
        description = "Sort direction",
        defaultValue = "DESC"
    )
    val direction: OrderDirection = OrderDirection.DESC
)