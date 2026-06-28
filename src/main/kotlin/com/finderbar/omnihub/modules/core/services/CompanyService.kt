package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import com.finderbar.omnihub.modules.core.mapper.CompanyMapper
import com.finderbar.omnihub.modules.core.query.CompanySearchQuery
import com.finderbar.omnihub.modules.core.repository.CompanyRepository
import com.finderbar.omnihub.modules.core.services.alias.CompanyCrudService
import com.finderbar.omnihub.modules.core.specification.CompanySpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*

@Service
class CompanyService(
    private val companyRepository: CompanyRepository,
    private val companyMapper: CompanyMapper,
) : CompanyCrudService(companyRepository) {

    override fun toSpecification(criteria: CompanySearchQuery): Specification<CompanyEntity> = CompanySpecification(criteria).build()

    override fun toPageable(criteria: CompanySearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): CompanyEntity = super.findById(id) ?: throw NotFoundException("Company not found:", id)

    @MasterTransaction
    fun createCompany(command: CompanyCreateCommand): CompanyEntity {
        require(!companyRepository.existsByCode(command.code.trim())) {
            "Company code already exists"
        }
        val entity = companyMapper.toEntity(command)
        return super.create(entity)
    }

    fun updateCompany(id: UUID, command: CompanyUpdateCommand): CompanyEntity {
        val entity = findRequired(id)
        val result = companyMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrieveCompany(id: UUID): CompanyEntity = findRequired(id)

    fun retrieveAllCompanies(): List<CompanyEntity> = super.findAll()

    fun searchCompany(criteria: CompanySearchQuery): Page<CompanyEntity> = super.search(criteria)

    fun existsCode(code: String): Boolean = companyRepository.existsByCode(code.trim())

    fun removeCompany(id: UUID) = super.deleteById(id)
}