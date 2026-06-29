package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper
import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.PositionDecorator
import com.finderbar.omnihub.modules.core.facade.alias.PositionCrudFacade
import com.finderbar.omnihub.modules.core.mapper.PositionMapper
import com.finderbar.omnihub.modules.core.model.PositionModel
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import com.finderbar.omnihub.modules.core.services.PositionService
import org.springframework.stereotype.Service
import java.util.*

@Service
class PositionFacade(
    private val positionService: PositionService,
    private val positionMapper: PositionMapper,
    private val positionDecorator: PositionDecorator
): PositionCrudFacade() {
    override fun findAll(): ApiResponse<List<PositionModel>> {
        val models = positionService
            .retrieveAllPositions()
            .map(positionMapper::toModel)
            .map(positionDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<PositionModel> {
        val model = positionService
            .retrievePosition(id)
            .let(positionMapper::toModel)
            .let(positionDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: PositionSearchQuery): ApiResponse<PageResponse<PositionModel>> {
        val page = positionService.searchPosition(criteria)
        return success(
            PageMapper.from(page) { entity ->
                positionDecorator.decorate(
                    positionMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: PositionCreateCommand): ApiResponse<PositionModel> {
        val entity = positionService.createPosition(command)
        val model = entity
            .let(positionMapper::toModel)
            .let(positionDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: PositionUpdateCommand
    ): ApiResponse<PositionModel> {
        val entity = positionService.updatePosition(id, command)
        val model = entity
            .let(positionMapper::toModel)
            .let(positionDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        positionService.removePosition(id)
    }

}