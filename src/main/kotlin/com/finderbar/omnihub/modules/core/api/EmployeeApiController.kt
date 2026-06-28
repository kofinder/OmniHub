package com.finderbar.omnihub.modules.core.api
import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.EmployeeCreateCommand
import com.finderbar.omnihub.modules.core.command.EmployeeUpdateCommand
import com.finderbar.omnihub.modules.core.facade.EmployeeFacade
import com.finderbar.omnihub.modules.core.model.EmployeeModel
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/employees")
@Tag(name = "Employee", description = "Employee Management API")
class EmployeeApiController(private val facade: EmployeeFacade) {

    @Operation(summary = "Get all employees")
    @GetMapping
    fun findAll(): ApiResponse<List<EmployeeModel>> = facade.findAll()

    @Operation(summary = "Search employees")
    @PostMapping("/search")
    fun search(
        @RequestBody criteria: EmployeeSearchQuery
    ): ApiResponse<PageResponse<EmployeeModel>> = facade.search(criteria)

    @Operation(summary = "Get employee by ID")
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: UUID
    ): ApiResponse<EmployeeModel> = facade.find(id)

    @Operation(summary = "Create employee")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody command: EmployeeCreateCommand
    ): ApiResponse<EmployeeModel> = facade.create(command)

    @Operation(summary = "Update employee")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @Valid @RequestBody command: EmployeeUpdateCommand
    ): ApiResponse<EmployeeModel> = facade.update(id, command)

    @Operation(summary = "Delete employee")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: UUID
    ) = facade.delete(id)
}