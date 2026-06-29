package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.DepartmentCreateCommand
import com.finderbar.omnihub.modules.core.command.DepartmentUpdateCommand
import com.finderbar.omnihub.modules.core.entity.DepartmentEntity
import com.finderbar.omnihub.modules.core.mapper.DepartmentMapper
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import com.finderbar.omnihub.modules.core.repository.DepartmentRepository
import com.finderbar.omnihub.modules.core.services.alias.DepartmentCrudService
import com.finderbar.omnihub.modules.core.specification.DepartmentSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class DepartmentService(
    private val departRepository: DepartmentRepository,
    private val departMapper: DepartmentMapper,
) : DepartmentCrudService(departRepository) {
    
    override fun toSpecification(criteria: DepartmentSearchQuery): Specification<DepartmentEntity> = DepartmentSpecification(criteria).build()

    override fun toPageable(criteria: DepartmentSearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): DepartmentEntity = super.findById(id) ?: throw NotFoundException("Department not found:", id)

    @MasterTransaction
    fun createDepartment(command: DepartmentCreateCommand): DepartmentEntity {
        val entity = departMapper.toEntity(command)
        return super.create(entity)
    }

    fun updateDepartment(id: UUID, command: DepartmentUpdateCommand): DepartmentEntity {
        val entity = findRequired(id)
        val result = departMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrieveDepartment(id: UUID): DepartmentEntity = findRequired(id)

    fun retrieveAllDepartments(): List<DepartmentEntity> = super.findAll()

    fun searchDepartment(criteria: DepartmentSearchQuery): Page<DepartmentEntity> = super.search(criteria)

    fun removeDepartment(id: UUID) = super.deleteById(id)

}