package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.CompanyModel
import com.finderbar.omnihub.modules.core.repository.BranchRepository
import com.finderbar.omnihub.modules.core.repository.OfficeRepository
import org.springframework.stereotype.Component

@Component
class CompanyDecorator(
    private val branchRepository: BranchRepository,
    private val officeRepository: OfficeRepository
) : AbstractDecorator<CompanyModel>() {
    override fun decorate(
        target: CompanyModel
    ): CompanyModel {
        target.branchCount = branchRepository.countByCompanyId(target.id)
        target.officeCount = officeRepository.countByCompanyId(target.id)
        return target
    }
}