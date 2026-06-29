package com.finderbar.omnihub.modules.core.command


import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.time.LocalDate
import java.util.UUID

@Schema(description = "Create Employee Request")
data class EmployeeCreateCommand(

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Unique employee number",
        example = "EMP000001",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val employeeNo: String,

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Employee first name",
        example = "John",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val firstName: String,

    @field:NotBlank
    @field:Size(max = 100)
    @Schema(
        description = "Employee last name",
        example = "Doe",
        maxLength = 100,
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val lastName: String,

    @field:NotNull
    @Schema(
        description = "Department ID",
        example = "7fbbcc80-58a0-43d8-b83d-4cc2d7e6468f",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val departmentId: UUID,

    @field:NotNull
    @Schema(
        description = "Position ID",
        example = "d1db57df-b15e-4cb4-b22b-01f72c7d8d83",
        requiredMode = Schema.RequiredMode.REQUIRED
    )
    val positionId: UUID,

    @field:Size(max = 50)
    @field:Pattern(
        regexp = "^[0-9+\\-() ]*$",
        message = "Invalid phone number"
    )
    @Schema(
        description = "Employee phone number",
        example = "+66-81-234-5678"
    )
    val phone: String? = null,

    @field:Email
    @field:Size(max = 255)
    @Schema(
        description = "Employee email address",
        example = "john.doe@company.com"
    )
    val email: String? = null,

    @Schema(
        description = "Employee hire date",
        example = "2025-01-15"
    )
    val hireDate: LocalDate? = null,

    @Schema(
        description = "Employee status",
        example = "true",
        defaultValue = "true"
    )
    val active: Boolean = true
)