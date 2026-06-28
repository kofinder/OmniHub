package com.finderbar.omnihub.modules.core.api
import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.facade.OfficeFacade
import com.finderbar.omnihub.modules.core.model.OfficeModel
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/offices")
@Tag(name = "Office", description = "Office Management API")
class OfficeApiController(private val facade: OfficeFacade) {

    @Operation(summary = "Get all offices")
    @GetMapping
    fun findAll(): ApiResponse<List<OfficeModel>> = facade.findAll()

    @Operation(summary = "Search offices")
    @PostMapping("/search")
    fun search(
        @RequestBody criteria: OfficeSearchQuery
    ): ApiResponse<PageResponse<OfficeModel>> = facade.search(criteria)

    @Operation(summary = "Get office by ID")
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: UUID
    ): ApiResponse<OfficeModel> = facade.find(id)

    @Operation(summary = "Create office")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody command: OfficeCreateCommand
    ): ApiResponse<OfficeModel> = facade.create(command)

    @Operation(summary = "Update office")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @Valid @RequestBody command: OfficeUpdateCommand
    ): ApiResponse<OfficeModel> = facade.update(id, command)

    @Operation(summary = "Delete office")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: UUID
    ) = facade.delete(id)
}