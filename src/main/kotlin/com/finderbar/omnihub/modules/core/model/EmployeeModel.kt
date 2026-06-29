package com.finderbar.omnihub.modules.core.model


import io.swagger.v3.oas.annotations.media.Schema
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

@Schema(description = "Employee")
data class EmployeeModel(

    @Schema(
        description = "Employee ID",
        example = "2fb2d3b9-5d91-4d63-a9d6-44bff1d6fd39"
    )
    val id: UUID,

    @Schema(
        description = "Unique employee number",
        example = "EMP000001"
    )
    val employeeNo: String,

    @Schema(
        description = "Employee first name",
        example = "John"
    )
    val firstName: String,

    @Schema(
        description = "Employee last name",
        example = "Doe"
    )
    val lastName: String,

    @Schema(
        description = "Employee full name",
        example = "John Doe"
    )
    val fullName: String,

    @Schema(
        description = "Department ID",
        example = "7fbbcc80-58a0-43d8-b83d-4cc2d7e6468f"
    )
    val departmentId: UUID,

    @Schema(
        description = "Department name",
        example = "Information Technology"
    )
    val departmentName: String,

    @Schema(
        description = "Position ID",
        example = "d1db57df-b15e-4cb4-b22b-01f72c7d8d83"
    )
    val positionId: UUID,

    @Schema(
        description = "Position name",
        example = "Software Engineer"
    )
    val positionName: String,

    @Schema(
        description = "Employee phone number",
        example = "+66-81-234-5678"
    )
    val phone: String?,

    @Schema(
        description = "Employee email address",
        example = "john.doe@company.com"
    )
    val email: String?,

    @Schema(
        description = "Employee hire date",
        example = "2025-01-15"
    )
    val hireDate: LocalDate?,

    @Schema(
        description = "Employee status",
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