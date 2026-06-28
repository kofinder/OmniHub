package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
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
        TODO("Not yet implemented")
    }

    override fun find(id: UUID): ApiResponse<EmployeeModel> {
        TODO("Not yet implemented")
    }

    override fun search(criteria: EmployeeSearchQuery): ApiResponse<PageResponse<EmployeeModel>> {
        TODO("Not yet implemented")
    }

    override fun create(command: EmployeeCreateCommand): ApiResponse<EmployeeModel> {
        TODO("Not yet implemented")
    }

    override fun update(
        id: UUID,
        command: EmployeeUpdateCommand
    ): ApiResponse<EmployeeModel> {
        TODO("Not yet implemented")
    }

    override fun delete(id: UUID) {
        TODO("Not yet implemented")
    }

}