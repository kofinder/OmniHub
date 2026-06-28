package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import com.finderbar.omnihub.modules.core.mapper.BusinessMapper
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import com.finderbar.omnihub.modules.core.repository.BusinessRepository
import com.finderbar.omnihub.modules.core.services.alias.BusinessCrudService
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service


@Service
class BusinessService(
    private val businessRepository: BusinessRepository,
    private val businessMapper: BusinessMapper,
) : BusinessCrudService(businessRepository) {

    override fun toSpecification(criteria: BusinessSearchQuery): Specification<BusinessEntity> {
        TODO("Not yet implemented")
    }

}