package com.finderbar.omnihub.modules.core.model


import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Office")
data class OfficeModel(

    @Schema(
        description = "Office ID",
        example = "9d9dcd5d-c8d8-4b44-a63c-886f83891d8e"
    )
    val id: UUID,

    @Schema(
        description = "Unique office code",
        example = "BKK-HQ"
    )
    val code: String,

    @Schema(
        description = "Office name",
        example = "Bangkok Head Office"
    )
    val name: String,

    @Schema(
        description = "Company ID",
        example = "0f6d1b96-9f26-45c7-a3a8-8c31d9af4b53"
    )
    val companyId: UUID,

    @Schema(
        description = "Company name",
        example = "ABC Holdings Co., Ltd."
    )
    val companyName: String,

    @Schema(
        description = "Office phone number",
        example = "+66-2-123-4567"
    )
    val phone: String?,

    @Schema(
        description = "Office email address",
        example = "bangkok.office@company.com"
    )
    val email: String?,

    @Schema(
        description = "Office address",
        example = "99 Sukhumvit Road, Khlong Toei, Bangkok 10110"
    )
    val address: String?,

    @Schema(
        description = "Office status",
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