package com.finderbar.omnihub.modules.core.model


import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Department")
data class DepartmentModel(

    @Schema(
        description = "Department ID",
        example = "e6cb1b2d-61d8-4e54-97d9-62eaf22d29a7"
    )
    val id: UUID,

    @Schema(
        description = "Unique department code",
        example = "IT"
    )
    val code: String,

    @Schema(
        description = "Department name",
        example = "Information Technology"
    )
    val name: String,

    @Schema(
        description = "Business ID",
        example = "6ef64d68-3028-4b8f-b8a2-63df7e86f67f"
    )
    val businessId: UUID,

    @Schema(
        description = "Business code",
        example = "BUS001"
    )
    val businessCode: String,

    @Schema(
        description = "Business name",
        example = "ABC Trading Co., Ltd."
    )
    val businessName: String,

    @Schema(
        description = "Department description",
        example = "Responsible for software development and IT infrastructure."
    )
    val description: String?,

    @Schema(
        description = "Department status",
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