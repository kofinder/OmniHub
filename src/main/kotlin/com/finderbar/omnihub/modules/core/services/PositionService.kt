package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.entity.PositionEntity
import com.finderbar.omnihub.modules.core.mapper.PositionMapper
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import com.finderbar.omnihub.modules.core.repository.PositionRepository
import com.finderbar.omnihub.modules.core.services.alias.PositionCrudService
import com.finderbar.omnihub.modules.core.specification.PositionSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*


@Service
class PositionService(
    private val positionRepository: PositionRepository,
    private val positionMapper: PositionMapper,
) : PositionCrudService(positionRepository) {
    override fun toSpecification(criteria: PositionSearchQuery): Specification<PositionEntity> = PositionSpecification(criteria).build()

    override fun toPageable(criteria: PositionSearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): PositionEntity = super.findById(id) ?: throw NotFoundException("Position not found:", id)

    @MasterTransaction
    fun createPosition(command: PositionCreateCommand): PositionEntity {
        val entity = positionMapper.toEntity(command)
        return super.create(entity)
    }

    fun updatePosition(id: UUID, command: PositionUpdateCommand): PositionEntity {
        val entity = findRequired(id)
        val result = positionMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrievePosition(id: UUID): PositionEntity = findRequired(id)

    fun retrieveAllPositions(): List<PositionEntity> = super.findAll()

    fun searchPosition(criteria: PositionSearchQuery): Page<PositionEntity> = super.search(criteria)

    fun removePosition(id: UUID) = super.deleteById(id)
}