package com.finderbar.omnihub.modules.core.services.alias

import com.finderbar.omnihub.core.services.AbstractCrudService
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import com.finderbar.omnihub.modules.core.query.CompanySearchQuery
import com.finderbar.omnihub.modules.core.repository.CompanyRepository

abstract class CompanyCrudService(
    repository: CompanyRepository
) : AbstractCrudService<
    CompanyEntity,
    CompanySearchQuery,
    CompanyRepository
>(repository)