package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper
import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.OfficeDecorator
import com.finderbar.omnihub.modules.core.facade.alias.OfficeCrudFacade
import com.finderbar.omnihub.modules.core.mapper.OfficeMapper
import com.finderbar.omnihub.modules.core.model.OfficeModel
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import com.finderbar.omnihub.modules.core.services.OfficeService
import org.springframework.stereotype.Service
import java.util.*


@Service
class OfficeFacade(
    private val officeService: OfficeService,
    private val officeMapper: OfficeMapper,
    private val officeDecorator: OfficeDecorator
): OfficeCrudFacade() {
    override fun findAll(): ApiResponse<List<OfficeModel>> {
        val models = officeService
            .retrieveAllOffices()
            .map(officeMapper::toModel)
            .map(officeDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<OfficeModel> {
        val model = officeService
            .retrieveOffice(id)
            .let(officeMapper::toModel)
            .let(officeDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: OfficeSearchQuery): ApiResponse<PageResponse<OfficeModel>> {
        val page = officeService.searchOffice(criteria)
        return success(
            PageMapper.from(page) { entity ->
                officeDecorator.decorate(
                    officeMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: OfficeCreateCommand): ApiResponse<OfficeModel> {
        val entity = officeService.createOffice(command)
        val model = entity
            .let(officeMapper::toModel)
            .let(officeDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: OfficeUpdateCommand
    ): ApiResponse<OfficeModel> {
        val entity = officeService.updateOffice(id, command)
        val model = entity
            .let(officeMapper::toModel)
            .let(officeDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        officeService.removeOffice(id)
    }
}