package com.finderbar.omnihub.modules.core.command


import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Update Company Command")
data class CompanyUpdateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Unique company code",
        example = "COMP001",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val code: String,

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Company name",
        example = "ABC Holdings Co., Ltd.",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:Size(max = 255)
    @Schema(
        description = "Company tax identification number",
        example = "0105551234567",
        maxLength = 255
    )
    val taxId: String?,

    @field:Size(max = 50)
    @Schema(
        description = "Company contact phone number",
        example = "+66-2-123-4567",
        maxLength = 50
    )
    val phone: String?,

    @field:Email
    @Schema(
        description = "Company email address",
        example = "contact@abc.com"
    )
    val email: String?,

    @Schema(
        description = "Company address",
        example = "99 Sukhumvit Road, Khlong Toei, Bangkok 10110"
    )
    val address: String?,

    @Schema(
        description = "Company status",
        example = "true"
    )
    val active: Boolean
)