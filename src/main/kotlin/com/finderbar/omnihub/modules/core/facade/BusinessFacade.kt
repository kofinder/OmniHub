package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
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
        TODO("Not yet implemented")
    }

    override fun find(id: UUID): ApiResponse<BusinessModel> {
        TODO("Not yet implemented")
    }

    override fun search(criteria: BusinessSearchQuery): ApiResponse<PageResponse<BusinessModel>> {
        TODO("Not yet implemented")
    }

    override fun create(command: BusinessCreateCommand): ApiResponse<BusinessModel> {
        TODO("Not yet implemented")
    }

    override fun update(
        id: UUID,
        command: BusinessUpdateCommand
    ): ApiResponse<BusinessModel> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

}