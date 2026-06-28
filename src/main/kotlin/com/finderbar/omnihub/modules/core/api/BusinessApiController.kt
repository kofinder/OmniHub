package com.finderbar.omnihub.modules.core.api

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.BusinessCreateCommand
import com.finderbar.omnihub.modules.core.command.BusinessUpdateCommand
import com.finderbar.omnihub.modules.core.facade.BusinessFacade
import com.finderbar.omnihub.modules.core.model.BusinessModel
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*


@RestController
@RequestMapping("/api/v1/businesses")
@Tag(name = "Business", description = "Business Management API")
class BusinessApiController(private val facade: BusinessFacade) {

    @Operation(summary = "Get all businesses")
    @GetMapping
    fun findAll(): ApiResponse<List<BusinessModel>> = facade.findAll()

    @Operation(summary = "Search businesses")
    @PostMapping("/search")
    fun search(
        @RequestBody criteria: BusinessSearchQuery
    ): ApiResponse<PageResponse<BusinessModel>> = facade.search(criteria)

    @Operation(summary = "Get business by ID")
    @GetMapping("/{id}")
    fun findById(
        @PathVariable id: UUID
    ): ApiResponse<BusinessModel> = facade.find(id)

    @Operation(summary = "Create business")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody command: BusinessCreateCommand
    ): ApiResponse<BusinessModel> = facade.create(command)

    @Operation(summary = "Update business")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @Valid @RequestBody command: BusinessUpdateCommand
    ): ApiResponse<BusinessModel> = facade.update(id, command)

    @Operation(summary = "Delete business")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(
        @PathVariable id: UUID
    ) = facade.delete(id)
}