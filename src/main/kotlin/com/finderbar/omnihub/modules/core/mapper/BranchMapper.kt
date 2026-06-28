package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.core.extenstion.clean
import com.finderbar.omnihub.core.extenstion.cleanOrNull
import com.finderbar.omnihub.modules.core.command.BranchCreateCommand
import com.finderbar.omnihub.modules.core.command.BranchUpdateCommand
import com.finderbar.omnihub.modules.core.entity.BranchEntity
import com.finderbar.omnihub.modules.core.mapper.alias.BranchEntityMapper
import com.finderbar.omnihub.modules.core.model.BranchModel
import com.finderbar.omnihub.modules.core.repository.OfficeRepository
import org.springframework.stereotype.Component


@Component
class BranchMapper(
    private val officeRepository: OfficeRepository
) : BranchEntityMapper() {
    override fun toModel(entity: BranchEntity): BranchModel =
        BranchModel(
            id = entity.id!!,
            name = entity.name,
            code = entity.code,
            officeId = entity.office.id!!,
            officeName = entity.office.name,
            phone = entity.phone,
            email = entity.email,
            address = entity.address,
            active = entity.active
        )

    override fun toEntity(model: BranchCreateCommand): BranchEntity {

        val office = officeRepository.findById(model.officeId)
            .orElseThrow {
                IllegalArgumentException("Office not found: ${model.officeId}")
            }

        return BranchEntity(
            name = model.name.clean(),
            code = model.code.clean(),
            office = office,
            phone = model.phone.cleanOrNull(),
            email = model.email.cleanOrNull(),
            address = model.address.cleanOrNull(),
            active = model.active
        )
    }

    override fun updateEntity(
        entity: BranchEntity,
        model: BranchUpdateCommand
    ): BranchEntity {

        entity.name = model.name.clean()
        entity.code = model.code.clean()

        // update office only if changed
        if (entity.office.id != model.officeId) {
            val office = officeRepository.findById(model.officeId)
                .orElseThrow {
                    IllegalArgumentException("Office not found: ${model.officeId}")
                }
            entity.office = office
        }

        entity.phone = model.phone.cleanOrNull()
        entity.email = model.email.cleanOrNull()
        entity.address = model.address.cleanOrNull()
        entity.active = model.active

        return entity
    }

}