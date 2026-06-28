package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.PositionDecorator
import com.finderbar.omnihub.modules.core.facade.alias.PositionCrudFacade
import com.finderbar.omnihub.modules.core.mapper.PositionMapper
import com.finderbar.omnihub.modules.core.model.PositionModel
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import com.finderbar.omnihub.modules.core.services.PositionService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class PositionFacade(
    private val positionService: PositionService,
    private val positionMapper: PositionMapper,
    private val positionDecorator: PositionDecorator
): PositionCrudFacade() {
    override fun findAll(): ApiResponse<List<PositionModel>> {
        TODO("Not yet implemented")
    }

    override fun find(id: UUID): ApiResponse<PositionModel> {
        TODO("Not yet implemented")
    }

    override fun search(criteria: PositionSearchQuery): ApiResponse<PageResponse<PositionModel>> {
        TODO("Not yet implemented")
    }

    override fun create(command: PositionCreateCommand): ApiResponse<PositionModel> {
        TODO("Not yet implemented")
    }

    override fun update(
        id: UUID,
        command: PositionUpdateCommand
    ): ApiResponse<PositionModel> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

}