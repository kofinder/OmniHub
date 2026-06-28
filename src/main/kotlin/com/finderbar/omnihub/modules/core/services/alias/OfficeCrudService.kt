package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import com.finderbar.omnihub.modules.core.repository.OfficeRepository

abstract class OfficeCrudService(
    repository: OfficeRepository
) : AbstractCrudService<
    OfficeEntity,
    OfficeSearchQuery,
    OfficeRepository
>(repository)