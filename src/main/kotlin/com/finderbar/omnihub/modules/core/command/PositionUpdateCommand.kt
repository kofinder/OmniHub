package com.finderbar.omnihub.modules.core.command

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Update Position Request")
data class PositionUpdateCommand(

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Position name",
        example = "Senior Software Engineer",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:Size(max = 1000)
    @Schema(
        description = "Position description",
        example = "Responsible for designing, developing, and maintaining enterprise applications."
    )
    val description: String? = null,

    @Schema(
        description = "Position status",
        example = "true"
    )
    val active: Boolean = true
)