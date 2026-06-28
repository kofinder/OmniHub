package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import com.finderbar.omnihub.modules.core.mapper.OfficeMapper
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import com.finderbar.omnihub.modules.core.repository.OfficeRepository
import com.finderbar.omnihub.modules.core.services.alias.OfficeCrudService
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service


@Service
class OfficeService(
    private val officeRepository: OfficeRepository,
    private val officeMapper: OfficeMapper,
) : OfficeCrudService(officeRepository) {
    override fun toSpecification(criteria: OfficeSearchQuery): Specification<OfficeEntity> {
        TODO("Not yet implemented")
    }
}