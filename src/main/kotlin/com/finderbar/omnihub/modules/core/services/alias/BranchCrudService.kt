package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.BranchEntity
import com.finderbar.omnihub.modules.core.query.BranchSearchQuery
import com.finderbar.omnihub.modules.core.repository.BranchRepository

abstract class BranchCrudService(
    repository: BranchRepository
) : AbstractCrudService<
    BranchEntity,
    BranchSearchQuery,
    BranchRepository
>(repository)
