package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.EmployeeDecorator
import com.finderbar.omnihub.modules.core.decorator.OfficeDecorator
import com.finderbar.omnihub.modules.core.facade.alias.EmployeeCrudFacade
import com.finderbar.omnihub.modules.core.facade.alias.OfficeCrudFacade
import com.finderbar.omnihub.modules.core.mapper.EmployeeMapper
import com.finderbar.omnihub.modules.core.mapper.OfficeMapper
import com.finderbar.omnihub.modules.core.model.OfficeModel
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import com.finderbar.omnihub.modules.core.services.EmployeeService
import com.finderbar.omnihub.modules.core.services.OfficeService
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class OfficeFacade(
    private val officeService: OfficeService,
    private val officeMapper: OfficeMapper,
    private val officeDecorator: OfficeDecorator
): OfficeCrudFacade() {
    override fun findAll(): ApiResponse<List<OfficeModel>> {
        TODO("Not yet implemented")
    }

    override fun find(id: UUID): ApiResponse<OfficeModel> {
        TODO("Not yet implemented")
    }

    override fun search(criteria: OfficeSearchQuery): ApiResponse<PageResponse<OfficeModel>> {
        TODO("Not yet implemented")
    }

    override fun create(command: OfficeCreateCommand): ApiResponse<OfficeModel> {
        TODO("Not yet implemented")
    }

    override fun update(
        id: UUID,
        command: OfficeUpdateCommand
    ): ApiResponse<OfficeModel> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

}