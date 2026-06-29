package com.finderbar.omnihub.modules.core.model

import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Business")
data class BusinessModel(

    @Schema(
        description = "Business ID",
        example = "8f98f0a1-3fd7-4b06-b18d-0d39f5d0f111"
    )
    val id: UUID,

    @Schema(
        description = "Unique business code",
        example = "COMP001"
    )
    val code: String,

    @Schema(
        description = "Business name",
        example = "ABC Trading Co., Ltd."
    )
    val name: String,

    @Schema(
        description = "Branch ID",
        example = "8f98f0a1-3fd7-4b06-b18d-0d39f5d0f111"
    )
    val branchId: UUID,

    @Schema(
        description = "Branch name",
        example = "Head Office"
    )
    val branchName: String,

    @Schema(
        description = "Business type ID",
        example = "77e8e969-706f-4c62-91ab-9d9737154a11"
    )
    val businessTypeId: UUID,

    @Schema(
        description = "Business type name",
        example = "Company"
    )
    val businessTypeName: String,

    @Schema(
        description = "Business registration number",
        example = "0105551234567"
    )
    val registrationNo: String?,

    @Schema(
        description = "Tax identification number",
        example = "0105551234567"
    )
    val taxId: String?,

    @Schema(
        description = "Business contact phone number",
        example = "+66-2-123-4567"
    )
    val phone: String?,

    @Schema(
        description = "Business email address",
        example = "contact@abc.com"
    )
    val email: String?,

    @Schema(
        description = "Business address",
        example = "99 ถนนสุขุมวิท กรุงเทพมหานคร"
    )
    val address: String?,

    @Schema(
        description = "Business status",
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
        example = "2025-01-02T10:00:00"
    )
    val updatedAt: LocalDateTime
)