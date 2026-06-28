package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.BranchModel
import com.finderbar.omnihub.modules.core.model.CompanyModel
import com.finderbar.omnihub.modules.core.repository.BranchRepository
import com.finderbar.omnihub.modules.core.repository.OfficeRepository
import org.springframework.stereotype.Component

@Component
class BranchDecorator(
    private val branchRepository: BranchRepository,
    private val officeRepository: OfficeRepository
) : AbstractDecorator<BranchModel>() {
    override fun decorate(
        target: BranchModel
    ): BranchModel {
        return target
    }
}