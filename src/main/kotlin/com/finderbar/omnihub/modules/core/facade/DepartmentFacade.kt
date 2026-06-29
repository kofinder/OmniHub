package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper
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
        val models = departmentService
            .retrieveAllDepartments()
            .map(departmentMapper::toModel)
            .map(departmentDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<DepartmentModel> {
        val model = departmentService
            .retrieveDepartment(id)
            .let(departmentMapper::toModel)
            .let(departmentDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: DepartmentSearchQuery): ApiResponse<PageResponse<DepartmentModel>> {
        val page = departmentService.searchDepartment(criteria)
        return success(
            PageMapper.from(page) { entity ->
                departmentDecorator.decorate(
                    departmentMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: DepartmentCreateCommand): ApiResponse<DepartmentModel> {
        val entity = departmentService.createDepartment(command)
        val model = entity
            .let(departmentMapper::toModel)
            .let(departmentDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: DepartmentUpdateCommand
    ): ApiResponse<DepartmentModel> {
        val entity = departmentService.updateDepartment(id, command)
        val model = entity
            .let(departmentMapper::toModel)
            .let(departmentDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        departmentService.removeDepartment(id)
    }
}