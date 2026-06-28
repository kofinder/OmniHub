package com.finderbar.omnihub.modules.core.command


import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Create Company Command")
data class CompanyCreateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Unique company code",
        example = "COMP001"
    )
    val code: String,

    @field:NotBlank
    @field:Size(max = 255)
    @Schema(
        description = "Company name",
        example = "Acme Corporation"
    )
    val name: String,

    @field:Size(max = 255)
    @Schema(
        description = "Tax identification number",
        example = "0105551234567"
    )
    val taxId: String?,

    @field:Size(max = 50)
    @Schema(
        description = "Phone number",
        example = "+66 2 123 4567"
    )
    val phone: String?,

    @field:Email
    @Schema(
        description = "Email address",
        example = "info@acme.com"
    )
    val email: String?,

    @Schema(
        description = "Company address",
        example = "Bangkok, Thailand"
    )
    val address: String?,

    @Schema(
        description = "Company status",
        example = "true"
    )
    val active: Boolean = true
)