package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.BusinessCreateCommand
import com.finderbar.omnihub.modules.core.command.BusinessUpdateCommand
import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import com.finderbar.omnihub.modules.core.mapper.BusinessMapper
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import com.finderbar.omnihub.modules.core.repository.BusinessRepository
import com.finderbar.omnihub.modules.core.services.alias.BusinessCrudService
import com.finderbar.omnihub.modules.core.specification.BusinessSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.UUID


@Service
class BusinessService(
    private val businessRepository: BusinessRepository,
    private val businessMapper: BusinessMapper,
) : BusinessCrudService(businessRepository) {

    override fun toSpecification(criteria: BusinessSearchQuery): Specification<BusinessEntity> = BusinessSpecification(criteria).build()

    override fun toPageable(criteria: BusinessSearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): BusinessEntity = super.findById(id) ?: throw NotFoundException("Business not found:", id)

    @MasterTransaction
    fun createBusiness(command: BusinessCreateCommand): BusinessEntity {
        val entity = businessMapper.toEntity(command)
        return super.create(entity)
    }

    fun updateBusiness(id: UUID, command: BusinessUpdateCommand): BusinessEntity {
        val entity = findRequired(id)
        val result = businessMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrieveBusiness(id: UUID): BusinessEntity = findRequired(id)

    fun retrieveAllBusiness(): List<BusinessEntity> = super.findAll()

    fun searchBusiness(criteria: BusinessSearchQuery): Page<BusinessEntity> = super.search(criteria)

    fun removeBusiness(id: UUID) = super.deleteById(id)

}