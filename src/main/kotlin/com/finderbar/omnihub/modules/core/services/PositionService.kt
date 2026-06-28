package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.modules.core.entity.PositionEntity
import com.finderbar.omnihub.modules.core.mapper.PositionMapper
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import com.finderbar.omnihub.modules.core.repository.PositionRepository
import com.finderbar.omnihub.modules.core.services.alias.PositionCrudService
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service


@Service
class PositionService(
    private val positionRepository: PositionRepository,
    private val positionMapper: PositionMapper,
) : PositionCrudService(positionRepository) {
    override fun toSpecification(criteria: PositionSearchQuery): Specification<PositionEntity> {
        TODO("Not yet implemented")
    }

}