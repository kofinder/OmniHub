package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper
import com.finderbar.omnihub.modules.core.command.EmployeeCreateCommand
import com.finderbar.omnihub.modules.core.command.EmployeeUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.EmployeeDecorator
import com.finderbar.omnihub.modules.core.facade.alias.EmployeeCrudFacade
import com.finderbar.omnihub.modules.core.mapper.EmployeeMapper
import com.finderbar.omnihub.modules.core.model.EmployeeModel
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import com.finderbar.omnihub.modules.core.services.EmployeeService
import org.springframework.stereotype.Service
import java.util.*

@Service
class EmployeeFacade(
    private val employeeService: EmployeeService,
    private val employeeMapper: EmployeeMapper,
    private val employeeDecorator: EmployeeDecorator
): EmployeeCrudFacade() {
    override fun findAll(): ApiResponse<List<EmployeeModel>> {
        val models = employeeService
            .retrieveAllEmployees()
            .map(employeeMapper::toModel)
            .map(employeeDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<EmployeeModel> {
        val model = employeeService
            .retrieveEmployee(id)
            .let(employeeMapper::toModel)
            .let(employeeDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: EmployeeSearchQuery): ApiResponse<PageResponse<EmployeeModel>> {
        val page = employeeService.searchEmployee(criteria)
        return success(
            PageMapper.from(page) { entity ->
                employeeDecorator.decorate(
                    employeeMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: EmployeeCreateCommand): ApiResponse<EmployeeModel> {
        val entity = employeeService.createEmployee(command)
        val model = entity
            .let(employeeMapper::toModel)
            .let(employeeDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: EmployeeUpdateCommand
    ): ApiResponse<EmployeeModel> {
        val entity = employeeService.updateEmployee(id, command)
        val model = entity
            .let(employeeMapper::toModel)
            .let(employeeDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        employeeService.removeEmployee(id)
    }

}