package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.BusinessCreateCommand
import com.finderbar.omnihub.modules.core.command.BusinessUpdateCommand
import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import com.finderbar.omnihub.modules.core.mapper.alias.BusinessEntityMapper
import com.finderbar.omnihub.modules.core.model.BusinessModel
import org.springframework.stereotype.Component


@Component
class BusinessMapper : BusinessEntityMapper() {
    override fun toModel(entity: BusinessEntity): BusinessModel {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: BusinessCreateCommand): BusinessEntity {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        entity: BusinessEntity,
        model: BusinessUpdateCommand
    ): BusinessEntity {
        TODO("Not yet implemented")
    }
}