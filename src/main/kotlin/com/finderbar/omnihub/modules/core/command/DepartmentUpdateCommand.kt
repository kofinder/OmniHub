package com.finderbar.omnihub.modules.core.command

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size
import java.util.UUID

@Schema(description = "Update Department Request")
data class DepartmentUpdateCommand(

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Department name",
        example = "Information Technology",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:NotNull
    @Schema(
        description = "Business ID",
        example = "6ef64d68-3028-4b8f-b8a2-63df7e86f67f",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val businessId: UUID,

    @field:Size(max = 1000)
    @Schema(
        description = "Department description",
        example = "Responsible for software development and IT infrastructure."
    )
    val description: String? = null,

    @Schema(
        description = "Department status",
        example = "true"
    )
    val active: Boolean = true
)