package com.finderbar.omnihub.modules.core.api

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.modules.core.facade.CompanyFacade
import com.finderbar.omnihub.modules.core.model.CompanyModel
import com.finderbar.omnihub.modules.core.query.CompanySearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/companies")
@Tag(name = "Company", description = "Company Management")
class CompanyApiController(
    private val facade: CompanyFacade
) {
    @Operation(summary = "Get all companies")
    @GetMapping
    fun findAll(): ApiResponse<List<CompanyModel>> = facade.findAll()

    @Operation(summary = "Search companies")
    @PostMapping("/search")
    fun search(
        @RequestBody criteria: CompanySearchQuery
    ): ApiResponse<PageResponse<CompanyModel>> = facade.search(criteria)

    @Operation(summary = "Get company by ID")
    @GetMapping("/{id}")
    fun find(
        @PathVariable id: UUID
    ): ApiResponse<CompanyModel> = facade.find(id)

    @Operation(summary = "Create company")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(
        @Valid @RequestBody command: CompanyCreateCommand
    ): ApiResponse<CompanyModel> = facade.create(command)

    @Operation(summary = "Update company")
    @PutMapping("/{id}")
    fun update(
        @PathVariable id: UUID,
        @Valid @RequestBody command: CompanyUpdateCommand
    ): ApiResponse<CompanyModel> = facade.update(id, command)

    @Operation(summary = "Delete company")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: UUID) {
        facade.delete(id)
    }
}