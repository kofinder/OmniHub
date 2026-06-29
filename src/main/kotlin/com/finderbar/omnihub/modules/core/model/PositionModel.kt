package com.finderbar.omnihub.modules.core.model

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Position")
data class PositionModel(

    @Schema(
        description = "Position ID",
        example = "f4d84040-c2a0-4f87-a91b-7c09c4ebeb2e"
    )
    val id: UUID,

    @Schema(
        description = "Unique position code",
        example = "DEV"
    )
    val code: String,

    @Schema(
        description = "Position name",
        example = "Software Developer"
    )
    val name: String,

    @Schema(
        description = "Position description",
        example = "Responsible for developing enterprise applications."
    )
    val description: String?,

    @Schema(
        description = "Position status",
        example = "true"
    )
    val active: Boolean,

    @Schema(
        description = "Created date and time",
        example = "2025-01-01T08:30:00"
    )
    val createdAt: LocalDateTime,

    @Schema(
        description = "Last updated date and time",
        example = "2025-01-10T15:45:00"
    )
    val updatedAt: LocalDateTime
)