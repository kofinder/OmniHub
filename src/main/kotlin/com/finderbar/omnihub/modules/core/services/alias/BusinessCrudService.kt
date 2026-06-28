package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import com.finderbar.omnihub.modules.core.repository.BusinessRepository

abstract class BusinessCrudService(
    repository: BusinessRepository
) : AbstractCrudService<
    BusinessEntity,
    BusinessSearchQuery,
    BusinessRepository
>(repository)
