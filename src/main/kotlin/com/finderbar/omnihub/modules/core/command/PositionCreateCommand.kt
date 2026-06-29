package com.finderbar.omnihub.modules.core.command


import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Create Position Request")
data class PositionCreateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Unique position code",
        example = "DEV",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val code: String,

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Position name",
        example = "Software Developer",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:Size(max = 1000)
    @Schema(
        description = "Position description",
        example = "Responsible for developing enterprise applications."
    )
    val description: String? = null,

    @Schema(
        description = "Position status",
        example = "true",
        defaultValue = "true"
    )
    val active: Boolean = true
)