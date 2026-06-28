package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.DepartmentEntity
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import com.finderbar.omnihub.modules.core.repository.DepartmentRepository


abstract class DepartmentCrudService(
    repository: DepartmentRepository
) : AbstractCrudService<
    DepartmentEntity,
    DepartmentSearchQuery,
    DepartmentRepository
>(repository)
