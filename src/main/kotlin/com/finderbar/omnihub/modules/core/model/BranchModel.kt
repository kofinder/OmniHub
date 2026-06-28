package com.finderbar.omnihub.modules.core.model


import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

@Schema(
    name = "BranchModel",
    description = "Branch response model returned to clients"
)
data class BranchModel(

    @Schema(
        description = "Unique branch ID",
        example = "550e8400-e29b-41d4-a716-446655440000"
    )
    val id: UUID,

    @Schema(
        description = "Branch name",
        example = "Main Branch"
    )
    val name: String,

    @Schema(
        description = "Unique branch code",
        example = "BR-001"
    )
    val code: String,

    @Schema(
        description = "Office ID this branch belongs to",
        example = "550e8400-e29b-41d4-a716-446655440000"
    )
    val officeId: UUID,

    @Schema(
        description = "Office name (denormalized for UI convenience)",
        example = "Head Office"
    )
    val officeName: String? = null,

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
        description = "Branch status (active/inactive)",
        example = "true"
    )
    val active: Boolean
)