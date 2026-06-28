package com.finderbar.omnihub.modules.core.facade

import com.finderbar.omnihub.core.api.ApiResponse
import com.finderbar.omnihub.core.api.PageResponse
import com.finderbar.omnihub.core.mapper.PageMapper
import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.modules.core.decorator.CompanyDecorator
import com.finderbar.omnihub.modules.core.facade.alias.CompanyCrudFacade
import com.finderbar.omnihub.modules.core.mapper.CompanyMapper
import com.finderbar.omnihub.modules.core.model.CompanyModel
import com.finderbar.omnihub.modules.core.query.CompanySearchQuery
import com.finderbar.omnihub.modules.core.services.CompanyService
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class CompanyFacade(
    private val companyService: CompanyService,
    private val companyDecorator: CompanyDecorator,
    private val companyMapper: CompanyMapper,
) : CompanyCrudFacade() {

    override fun findAll(): ApiResponse<List<CompanyModel>> {
        val models = companyService
            .retrieveAllCompanies()
            .map(companyMapper::toModel)
            .map(companyDecorator::decorate)
        return success(models)
    }

    override fun find(id: UUID): ApiResponse<CompanyModel> {
        val model = companyService
            .retrieveCompany(id)
            .let(companyMapper::toModel)
            .let(companyDecorator::decorate)
        return success(model)
    }

    override fun search(criteria: CompanySearchQuery): ApiResponse<PageResponse<CompanyModel>> {
        val page = companyService.searchCompany(criteria)
        return success(
            PageMapper.from(page) { entity ->
                companyDecorator.decorate(
                    companyMapper.toModel(entity)
                )
            }
        )
    }

    override fun create(command: CompanyCreateCommand): ApiResponse<CompanyModel> {
        val entity = companyService.createCompany(command)
        val model = entity
            .let(companyMapper::toModel)
            .let(companyDecorator::decorate)
        return success(model)
    }

    override fun update(
        id: UUID,
        command: CompanyUpdateCommand
    ): ApiResponse<CompanyModel> {
        val entity = companyService.updateCompany(id, command)
        val model = entity
            .let(companyMapper::toModel)
            .let(companyDecorator::decorate)
        return success(model)
    }

    override fun delete(id: UUID) {
        companyService.removeCompany(id)
    }
}