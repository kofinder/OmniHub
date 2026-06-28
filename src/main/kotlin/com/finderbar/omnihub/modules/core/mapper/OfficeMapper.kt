package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import com.finderbar.omnihub.modules.core.mapper.alias.OfficeEntityMapper
import com.finderbar.omnihub.modules.core.model.OfficeModel
import org.springframework.stereotype.Component


@Component
class OfficeMapper : OfficeEntityMapper() {
    override fun toModel(entity: OfficeEntity): OfficeModel {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: OfficeCreateCommand): OfficeEntity {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        entity: OfficeEntity,
        model: OfficeUpdateCommand
    ): OfficeEntity {
        TODO("Not yet implemented")
    }

}