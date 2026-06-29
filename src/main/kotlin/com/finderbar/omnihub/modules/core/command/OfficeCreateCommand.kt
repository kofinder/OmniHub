package com.finderbar.omnihub.modules.core.command

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.util.UUID

@Schema(description = "Create Office Request")
data class OfficeCreateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Unique office code",
        example = "BKK-HQ",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val code: String,

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Office name",
        example = "Bangkok Head Office",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:NotNull
    @Schema(
        description = "Company ID",
        example = "0f6d1b96-9f26-45c7-a3a8-8c31d9af4b53",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val companyId: UUID,

    @field:Size(max = 50)
    @field:Pattern(
        regexp = "^[0-9+\\-() ]*$",
        message = "Invalid phone number"
    )
    @Schema(
        description = "Office phone number",
        example = "+66-2-123-4567"
    )
    val phone: String? = null,

    @field:Email
    @field:Size(max = 255)
    @Schema(
        description = "Office email address",
        example = "bangkok.office@company.com"
    )
    val email: String? = null,

    @field:Size(max = 1000)
    @Schema(
        description = "Office address",
        example = "99 Sukhumvit Road, Khlong Toei, Bangkok 10110"
    )
    val address: String? = null,

    @Schema(
        description = "Office status",
        example = "true",
        defaultValue = "true"
    )
    val active: Boolean = true
)