package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import com.finderbar.omnihub.modules.core.mapper.OfficeMapper
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import com.finderbar.omnihub.modules.core.repository.OfficeRepository
import com.finderbar.omnihub.modules.core.services.alias.OfficeCrudService
import com.finderbar.omnihub.modules.core.specification.OfficeSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*


@Service
class OfficeService(
    private val officeRepository: OfficeRepository,
    private val officeMapper: OfficeMapper,
) : OfficeCrudService(officeRepository) {

    override fun toSpecification(criteria: OfficeSearchQuery): Specification<OfficeEntity> = OfficeSpecification(criteria).build()

    override fun toPageable(criteria: OfficeSearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): OfficeEntity = super.findById(id) ?: throw NotFoundException("Office not found:", id)

    @MasterTransaction
    fun createOffice(command: OfficeCreateCommand): OfficeEntity {
        val entity = officeMapper.toEntity(command)
        return super.create(entity)
    }

    fun updateOffice(id: UUID, command: OfficeUpdateCommand): OfficeEntity {
        val entity = findRequired(id)
        val result = officeMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrieveOffice(id: UUID): OfficeEntity = findRequired(id)

    fun retrieveAllOffices(): List<OfficeEntity> = super.findAll()

    fun searchOffice(criteria: OfficeSearchQuery): Page<OfficeEntity> = super.search(criteria)

    fun removeOffice(id: UUID) = super.deleteById(id)
}