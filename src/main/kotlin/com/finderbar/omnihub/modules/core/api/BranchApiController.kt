package com.finderbar.omnihub.modules.core.api
import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.BranchCreateCommand
import com.finderbar.omnihub.modules.core.command.BranchUpdateCommand
import com.finderbar.omnihub.modules.core.facade.BranchFacade
import com.finderbar.omnihub.modules.core.model.BranchModel
import com.finderbar.omnihub.modules.core.query.BranchSearchQuery
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/v1/branches")
@Tag(name = "Branch", description = "Branch Management APIs")
class BranchApiController(private val facade: BranchFacade) {

    @Operation(summary = "Get all branches")
    @GetMapping
    fun findAll(): ApiResponse<List<BranchModel>> = facade.findAll()

    @Operation(summary = "Search branches")
    @PostMapping("/search")
    fun searchBranches(
        @RequestBody criteria: BranchSearchQuery
    ): ApiResponse<PageResponse<BranchModel>> = facade.search(criteria)

    @Operation(summary = "Get branch by ID")
    @GetMapping("/{id}")
    fun findByBranchId(
        @PathVariable id: UUID
    ): ApiResponse<BranchModel> = facade.find(id)

    @Operation(summary = "Create branch")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createNewBranch(
        @Valid @RequestBody command: BranchCreateCommand
    ): ApiResponse<BranchModel> = facade.create(command)

    @Operation(summary = "Update branch")
    @PutMapping("/{id}")
    fun updateExistingBranch(
        @PathVariable id: UUID,
        @Valid @RequestBody command: BranchUpdateCommand
    ): ApiResponse<BranchModel> = facade.update(id, command)

    @Operation(summary = "Delete branch")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteBranch(@PathVariable id: UUID ) = facade.delete(id)
}