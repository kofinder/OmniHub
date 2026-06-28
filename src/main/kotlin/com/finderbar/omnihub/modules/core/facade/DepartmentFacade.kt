package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.modules.core.command.DepartmentCreateCommand
import com.finderbar.omnihub.modules.core.command.DepartmentUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.DepartmentDecorator
import com.finderbar.omnihub.modules.core.facade.alias.DepartmentCrudFacade
import com.finderbar.omnihub.modules.core.mapper.DepartmentMapper
import com.finderbar.omnihub.modules.core.model.DepartmentModel
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import com.finderbar.omnihub.modules.core.services.DepartmentService
import org.springframework.stereotype.Service
import java.util.*


@Service
class DepartmentFacade(
    private val departmentService: DepartmentService,
    private val departmentMapper: DepartmentMapper,
    private val departmentDecorator: DepartmentDecorator
): DepartmentCrudFacade() {
    override fun findAll(): ApiResponse<List<DepartmentModel>> {
        TODO("Not yet implemented")
    }

    override fun find(id: UUID): ApiResponse<DepartmentModel> {
        TODO("Not yet implemented")
    }

    override fun search(criteria: DepartmentSearchQuery): ApiResponse<PageResponse<DepartmentModel>> {
        TODO("Not yet implemented")
    }

    override fun create(command: DepartmentCreateCommand): ApiResponse<DepartmentModel> {
        TODO("Not yet implemented")
    }

    override fun update(
        id: UUID,
        command: DepartmentUpdateCommand
    ): ApiResponse<DepartmentModel> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

}