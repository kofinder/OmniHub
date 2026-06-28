package com.finderbar.omnihub.modules.core.command


import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

@Schema(description = "Update Company Command")
data class CompanyUpdateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    val code: String,

    @field:NotBlank
    @field:Size(max = 255)
    val name: String,

    @field:Size(max = 255)
    val taxId: String?,

    @field:Size(max = 50)
    val phone: String?,

    @field:Email
    val email: String?,

    val address: String?,

    val active: Boolean
)