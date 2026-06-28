package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import com.finderbar.omnihub.modules.core.repository.EmployeeRepository

abstract class EmployeeCrudService(
    repository: EmployeeRepository
) : AbstractCrudService<
    EmployeeEntity,
    EmployeeSearchQuery,
    EmployeeRepository
>(repository)
