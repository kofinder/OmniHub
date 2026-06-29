package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper

import com.finderbar.omnihub.modules.core.command.BusinessCreateCommand
import com.finderbar.omnihub.modules.core.command.BusinessUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.BusinessDecorator
import com.finderbar.omnihub.modules.core.facade.alias.BusinessCrudFacade
import com.finderbar.omnihub.modules.core.mapper.BusinessMapper
import com.finderbar.omnihub.modules.core.model.BusinessModel
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import com.finderbar.omnihub.modules.core.services.BusinessService
import org.springframework.stereotype.Service
import java.util.*

@Service
class BusinessFacade(
    private val businessService: BusinessService,
    private val businessMapper: BusinessMapper,
    private val businessDecorator: BusinessDecorator
): BusinessCrudFacade() {

    override fun findAll(): ApiResponse<List<BusinessModel>> {
        val models = businessService
            .retrieveAllBusiness()
            .map(businessMapper::toModel)
            .map(businessDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<BusinessModel> {
        val model = businessService
            .retrieveBusiness(id)
            .let(businessMapper::toModel)
            .let(businessDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: BusinessSearchQuery): ApiResponse<PageResponse<BusinessModel>> {
        val page = businessService.searchBusiness(criteria)
        return success(
            PageMapper.from(page) { entity ->
                businessDecorator.decorate(
                    businessMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: BusinessCreateCommand): ApiResponse<BusinessModel> {
        val entity = businessService.createBusiness(command)
        val model = entity
            .let(businessMapper::toModel)
            .let(businessDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: BusinessUpdateCommand
    ): ApiResponse<BusinessModel> {
        val entity = businessService.updateBusiness(id, command)
        val model = entity
            .let(businessMapper::toModel)
            .let(businessDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        businessService.removeBusiness(id)
    }

}