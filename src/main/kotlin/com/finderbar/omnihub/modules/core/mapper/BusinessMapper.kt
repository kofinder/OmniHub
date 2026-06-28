package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import com.finderbar.omnihub.modules.core.mapper.alias.CompanyEntityMapper
import com.finderbar.omnihub.modules.core.model.CompanyModel
import org.springframework.stereotype.Component



@Component
class BusinessMapper : CompanyEntityMapper() {
    override fun toModel(entity: CompanyEntity): CompanyModel {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: CompanyCreateCommand): CompanyEntity {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        entity: CompanyEntity,
        model: CompanyUpdateCommand
    ): CompanyEntity {
        TODO("Not yet implemented")
    }
}