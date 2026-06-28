package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.PositionEntity
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import com.finderbar.omnihub.modules.core.repository.PositionRepository

abstract class PositionCrudService(
    repository: PositionRepository
) : AbstractCrudService<
    PositionEntity,
    PositionSearchQuery,
    PositionRepository
>(repository)