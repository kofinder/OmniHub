package com.finderbar.omnihub.modules.core.command

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import java.util.UUID


@Schema(
    name = "BranchCreateCommand",
    description = "Request payload for creating a new Branch"
)
data class BranchCreateCommand(

    @field:NotBlank
    @Schema(
        description = "Branch name",
        example = "Main Branch"
    )
    val name: String,

    @field:NotBlank
    @Schema(
        description = "Unique branch code",
        example = "BR-001"
    )
    val code: String,

    @field:NotNull
    @Schema(
        description = "Office ID that this branch belongs to",
        example = "550e8400-e29b-41d4-a716-446655440000"
    )
    val officeId: UUID,

    @Schema(
        description = "Branch phone number",
        example = "+66-812345678",
        nullable = true
    )
    val phone: String? = null,

    @Schema(
        description = "Branch email address",
        example = "branch@example.com",
        nullable = true
    )
    val email: String? = null,

    @Schema(
        description = "Branch physical address",
        example = "Bangkok, Thailand",
        nullable = true
    )
    val address: String? = null,

    @Schema(
        description = "Branch status",
        example = "true"
    )
    val active: Boolean = true
)