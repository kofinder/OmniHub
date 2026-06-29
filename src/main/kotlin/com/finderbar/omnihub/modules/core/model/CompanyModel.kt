package com.finderbar.omnihub.modules.core.model

import io.swagger.v3.oas.annotations.media.Schema
import java.util.UUID

@Schema(
    name = "Company",
    description = "Company information"
)
data class CompanyModel(

    @field:Schema(
        description = "Unique identifier",
        example = "550e8400-e29b-41d4-a716-446655440000"
    )
    val id: UUID,

    @field:Schema(
        description = "Unique company code",
        example = "COMP001"
    )
    val code: String,

    @field:Schema(
        description = "Company name",
        example = "Finderbar Co., Ltd."
    )
    val name: String,

    @field:Schema(
        description = "Tax identification number",
        example = "0105551234567",
        nullable = true
    )
    val taxId: String?,

    @field:Schema(
        description = "Contact phone number",
        example = "+66 2 123 4567",
        nullable = true
    )
    val phone: String?,

    @field:Schema(
        description = "Contact email address",
        example = "contact@finderbar.com",
        nullable = true
    )
    val email: String?,

    @field:Schema(
        description = "Company address",
        example = "Bangkok, Thailand",
        nullable = true
    )
    val address: String?,

    @field:Schema(
        description = "Whether the company is active",
        example = "true"
    )
    val active: Boolean,

    @field:Schema(
        description = "Number of branches under the company",
        example = "5",
        nullable = true
    )
    var branchCount: Long? = null,

    @field:Schema(
        description = "Number of offices under the company",
        example = "12",
        nullable = true
    )
    var officeCount: Long? = null
)