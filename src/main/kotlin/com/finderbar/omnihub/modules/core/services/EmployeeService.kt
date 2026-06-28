package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import com.finderbar.omnihub.modules.core.mapper.EmployeeMapper
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import com.finderbar.omnihub.modules.core.repository.EmployeeRepository
import com.finderbar.omnihub.modules.core.services.alias.EmployeeCrudService
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service


@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val employeeMapper: EmployeeMapper,
) : EmployeeCrudService(employeeRepository) {
    override fun toSpecification(criteria: EmployeeSearchQuery): Specification<EmployeeEntity> {
        TODO("Not yet implemented")
    }
}