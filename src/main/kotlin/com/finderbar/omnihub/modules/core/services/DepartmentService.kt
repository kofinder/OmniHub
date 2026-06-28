package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.modules.core.entity.DepartmentEntity
import com.finderbar.omnihub.modules.core.mapper.DepartmentMapper
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import com.finderbar.omnihub.modules.core.repository.DepartmentRepository
import com.finderbar.omnihub.modules.core.services.alias.DepartmentCrudService
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service


@Service
class DepartmentService(
    private val departRepository: DepartmentRepository,
    private val departMapper: DepartmentMapper,
) : DepartmentCrudService(departRepository) {
    override fun toSpecification(criteria: DepartmentSearchQuery): Specification<DepartmentEntity> {
        TODO("Not yet implemented")
    }
}