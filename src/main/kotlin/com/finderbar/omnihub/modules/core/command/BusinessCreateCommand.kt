package com.finderbar.omnihub.modules.core.command

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.util.UUID

@Schema(description = "Create Business Request")
data class BusinessCreateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Business code",
        example = "COMP001",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val code: String,

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Business name",
        example = "ABC Trading Co., Ltd.",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:NotNull
    @Schema(
        description = "Branch ID",
        example = "8f98f0a1-3fd7-4b06-b18d-0d39f5d0f111",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val branchId: UUID,

    @field:NotNull
    @Schema(
        description = "Business Type ID",
        example = "77e8e969-706f-4c62-91ab-9d9737154a11",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val businessTypeId: UUID,

    @field:Size(max = 100)
    @Schema(
        description = "Business registration number",
        example = "0105551234567"
    )
    val registrationNo: String? = null,

    @field:Size(max = 100)
    @Schema(
        description = "Tax ID",
        example = "0105551234567"
    )
    val taxId: String? = null,

    @field:Size(max = 50)
    @field:Pattern(
        regexp = "^[0-9+\\-() ]*$",
        message = "Invalid phone number"
    )
    @Schema(
        description = "Phone number",
        example = "+66-2-123-4567"
    )
    val phone: String? = null,

    @field:Email
    @field:Size(max = 255)
    @Schema(
        description = "Email address",
        example = "contact@abc.com"
    )
    val email: String? = null,

    @field:Size(max = 1000)
    @Schema(
        description = "Business address",
        example = "99 ถนนสุขุมวิท กรุงเทพมหานคร"
    )
    val address: String? = null,

    @Schema(
        description = "Business status",
        example = "true",
        defaultValue = "true"
    )
    val active: Boolean = true
)