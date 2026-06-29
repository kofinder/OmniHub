package com.finderbar.omnihub.modules.core.command

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.util.UUID


@Schema(
    name = "BusinessUpdateCommand",
    description = "Update Business Request"
)
data class BusinessUpdateCommand(

    @field:NotBlank
    @field:Size(max = 255)
    @field:Schema(
        description = "Business name",
        example = "ABC Trading Co., Ltd.",
        maxLength = 255,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val name: String,

    @field:NotNull
    @field:Schema(
        description = "Branch ID",
        example = "8f98f0a1-3fd7-4b06-b18d-0d39f5d0f111",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val branchId: UUID,

    @field:NotNull
    @field:Schema(
        description = "Business type ID",
        example = "77e8e969-706f-4c62-91ab-9d9737154a11",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val businessTypeId: UUID,

    @field:Size(max = 100)
    @field:Schema(
        description = "Business registration number",
        example = "0105551234567",
        maxLength = 100,
        nullable = true
    )
    val registrationNo: String? = null,

    @field:Size(max = 100)
    @field:Schema(
        description = "Tax identification number",
        example = "0105551234567",
        maxLength = 100,
        nullable = true
    )
    val taxId: String? = null,

    @field:Size(max = 50)
    @field:Pattern(regexp = "^[0-9+\\-() ]*$")
    @field:Schema(
        description = "Business contact phone number",
        example = "+66-2-123-4567",
        maxLength = 50,
        nullable = true
    )
    val phone: String? = null,

    @field:Email
    @field:Size(max = 255)
    @field:Schema(
        description = "Business email address",
        example = "contact@abc.com",
        maxLength = 255,
        nullable = true
    )
    val email: String? = null,

    @field:Size(max = 1000)
    @field:Schema(
        description = "Business address",
        example = "99 Sukhumvit Road, Khlong Toei, Bangkok 10110",
        nullable = true
    )
    val address: String? = null,

    @field:Schema(
        description = "Whether the business is active",
        example = "true"
    )
    val active: Boolean = true
)