package com.finderbar.omnihub.modules.core.api


import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.facade.PositionFacade
import com.finderbar.omnihub.modules.core.model.BranchModel
import com.finderbar.omnihub.modules.core.model.PositionModel
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/positions")
@Tag(name = "Position", description = "Position Management API")
class PositionApiController(private val facade: PositionFacade) {

    @Operation(summary = "Get all positions")
    @GetMapping
    fun findAll(): ApiResponse<List<PositionModel>> = facade.findAll()

    @Operation(summary = "Search positions")
    @PostMapping("/search")
    fun search(
        @RequestBody criteria: PositionSearchQuery
    ): ApiResponse<PageResponse<PositionModel>> = facade.search(criteria)

    @Operation(summary = "Get position by ID")
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: UUID
    ): ApiResponse<PositionModel> = facade.find(id)

    @Operation(summary = "Create position")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody command: PositionCreateCommand
    ): ApiResponse<PositionModel> = facade.create(command)

    @Operation(summary = "Update position")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @Valid @RequestBody command: PositionUpdateCommand
    ): ApiResponse<PositionModel> = facade.update(id, command)

    @Operation(summary = "Delete position")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: UUID
    ) = facade.delete(id)
}