package com.finderbar.omnihub.modules.core.api
import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.DepartmentCreateCommand
import com.finderbar.omnihub.modules.core.command.DepartmentUpdateCommand
import com.finderbar.omnihub.modules.core.facade.DepartmentFacade
import com.finderbar.omnihub.modules.core.model.DepartmentModel
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/departments")
@Tag(name = "Department", description = "Department Management API")
class DepartmentApiController(
    private val facade: DepartmentFacade
) {

    @Operation(summary = "Get all departments")
    @GetMapping
    fun findAll(): ApiResponse<List<DepartmentModel>> = facade.findAll()

    @Operation(summary = "Search departments")
    @PostMapping("/search")
    fun search(
        @RequestBody criteria: DepartmentSearchQuery
    ): ApiResponse<PageResponse<DepartmentModel>> = facade.search(criteria)

    @Operation(summary = "Get department by ID")
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: UUID
    ): ApiResponse<DepartmentModel> = facade.find(id)

    @Operation(summary = "Create department")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody command: DepartmentCreateCommand
    ): ApiResponse<DepartmentModel> = facade.create(command)

    @Operation(summary = "Update department")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @Valid @RequestBody command: DepartmentUpdateCommand
    ): ApiResponse<DepartmentModel> = facade.update(id, command)

    @Operation(summary = "Delete department")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: UUID
    ) = facade.delete(id)
}