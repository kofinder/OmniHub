package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper
import com.finderbar.omnihub.modules.core.command.BranchCreateCommand
import com.finderbar.omnihub.modules.core.command.BranchUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.BranchDecorator
import com.finderbar.omnihub.modules.core.facade.alias.BranchCrudFacade
import com.finderbar.omnihub.modules.core.mapper.BranchMapper
import com.finderbar.omnihub.modules.core.model.BranchModel
import com.finderbar.omnihub.modules.core.query.BranchSearchQuery
import com.finderbar.omnihub.modules.core.services.BranchService
import org.springframework.stereotype.Service
import java.util.*

@Service
class BranchFacade(
    private val branchService: BranchService,
    private val branchMapper: BranchMapper,
    private val branchDecorator: BranchDecorator
): BranchCrudFacade() {

    override fun findAll(): ApiResponse<List<BranchModel>> {
        val models = branchService
            .retrieveAllBranches()
            .map(branchMapper::toModel)
            .map(branchDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<BranchModel> {
        val model = branchService
            .retrieveBranch(id)
            .let(branchMapper::toModel)
            .let(branchDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: BranchSearchQuery): ApiResponse<PageResponse<BranchModel>> {
        val page = branchService.searchBranch(criteria)
        return success(
            PageMapper.from(page) { entity ->
                branchDecorator.decorate(
                    branchMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: BranchCreateCommand): ApiResponse<BranchModel> {
        val entity = branchService.createBranch(command)
        val model = entity
            .let(branchMapper::toModel)
            .let(branchDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: BranchUpdateCommand
    ): ApiResponse<BranchModel> {
        val entity = branchService.updateBranch(id, command)
        val model = entity
            .let(branchMapper::toModel)
            .let(branchDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        branchService.retrieveBranch(id)
    }
}