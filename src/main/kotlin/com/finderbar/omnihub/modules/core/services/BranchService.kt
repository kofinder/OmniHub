package com.finderbar.omnihub.modules.core.services

import com.finderbar.omnihub.annotations.MasterTransaction
import com.finderbar.omnihub.core.exception.NotFoundException
import com.finderbar.omnihub.core.pageable.PageableFactory
import com.finderbar.omnihub.modules.core.command.BranchCreateCommand
import com.finderbar.omnihub.modules.core.command.BranchUpdateCommand
import com.finderbar.omnihub.modules.core.entity.BranchEntity
import com.finderbar.omnihub.modules.core.mapper.BranchMapper
import com.finderbar.omnihub.modules.core.query.BranchSearchQuery
import com.finderbar.omnihub.modules.core.repository.BranchRepository
import com.finderbar.omnihub.modules.core.services.alias.BranchCrudService
import com.finderbar.omnihub.modules.core.specification.BranchSpecification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import java.util.*


@Service
class BranchService(
    private val branchRepository: BranchRepository,
    private val branchMapper: BranchMapper,
) : BranchCrudService(branchRepository) {

    override fun toSpecification(criteria: BranchSearchQuery): Specification<BranchEntity> = BranchSpecification(criteria).build()

    override fun toPageable(criteria: BranchSearchQuery): Pageable = PageableFactory.create(criteria)

    fun findRequired(id: UUID): BranchEntity = super.findById(id) ?: throw NotFoundException("Branch not found:", id)

    @MasterTransaction
    fun createBranch(command: BranchCreateCommand): BranchEntity {
        require(!branchRepository.existsByCode(command.code.trim())) {
            "Company code already exists"
        }
        val entity = branchMapper.toEntity(command)
        return super.create(entity)
    }

    fun updateBranch(id: UUID, command: BranchUpdateCommand): BranchEntity {
        val entity = findRequired(id)
        val result = branchMapper.updateEntity(entity, command)
        return super.update(result)
    }

    fun retrieveBranch(id: UUID): BranchEntity = findRequired(id)

    fun retrieveAllBranches(): List<BranchEntity> = super.findAll()

    fun searchBranch(criteria: BranchSearchQuery): Page<BranchEntity> = super.search(criteria)

    fun existsCode(code: String): Boolean = branchRepository.existsByCode(code.trim())

    fun removeBranch(id: UUID) = super.deleteById(id)
}