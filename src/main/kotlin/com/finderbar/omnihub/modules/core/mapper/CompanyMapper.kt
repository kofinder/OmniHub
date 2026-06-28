package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import com.finderbar.omnihub.modules.core.mapper.alias.CompanyEntityMapper
import com.finderbar.omnihub.modules.core.model.CompanyModel
import org.springframework.stereotype.Component


@Component
class CompanyMapper : CompanyEntityMapper() {

    override fun toModel(entity: CompanyEntity): CompanyModel {
        return CompanyModel(
            id = entity.id!!,
            code = entity.code,
            name = entity.name,
            taxId = entity.taxId,
            phone = entity.phone,
            email = entity.email,
            address = entity.address,
            active = entity.active
        )
    }

    override fun toEntity(model: CompanyCreateCommand): CompanyEntity {
        return CompanyEntity(
            code = model.code.trim(),
            name = model.name.trim(),
            taxId = model.taxId?.trim(),
            phone = model.phone?.trim(),
            email = model.email?.trim(),
            address = model.address?.trim(),
            active = model.active
        )
    }

    override fun updateEntity(
        entity: CompanyEntity,
        model: CompanyUpdateCommand
    ): CompanyEntity {
        entity.code = model.code.trim()
        entity.name = model.name.trim()
        entity.taxId = model.taxId?.trim()
        entity.phone = model.phone?.trim()
        entity.email = model.email?.trim()
        entity.address = model.address?.trim()
        entity.active = model.active
        return entity
    }
}