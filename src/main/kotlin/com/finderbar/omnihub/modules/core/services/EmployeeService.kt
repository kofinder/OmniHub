package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.EmployeeCreateCommand
import com.finderbar.omnihub.modules.core.command.EmployeeUpdateCommand
import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import com.finderbar.omnihub.modules.core.mapper.EmployeeMapper
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import com.finderbar.omnihub.modules.core.repository.EmployeeRepository
import com.finderbar.omnihub.modules.core.services.alias.EmployeeCrudService
import com.finderbar.omnihub.modules.core.specification.EmployeeSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*


@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository,
    private val employeeMapper: EmployeeMapper,
) : EmployeeCrudService(employeeRepository) {

    override fun toSpecification(criteria: EmployeeSearchQuery): Specification<EmployeeEntity> = EmployeeSpecification(criteria).build()

    override fun toPageable(criteria: EmployeeSearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): EmployeeEntity = super.findById(id) ?: throw NotFoundException("Employee not found:", id)

    @MasterTransaction
    fun createEmployee(command: EmployeeCreateCommand): EmployeeEntity {
        val entity = employeeMapper.toEntity(command)
        return super.create(entity)
    }

    fun updateEmployee(id: UUID, command: EmployeeUpdateCommand): EmployeeEntity {
        val entity = findRequired(id)
        val result = employeeMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrieveEmployee(id: UUID): EmployeeEntity = findRequired(id)

    fun retrieveAllEmployees(): List<EmployeeEntity> = super.findAll()

    fun searchEmployee(criteria: EmployeeSearchQuery): Page<EmployeeEntity> = super.search(criteria)

    fun removeEmployee(id: UUID) = super.deleteById(id)

}