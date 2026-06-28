package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.entity.PositionEntity
import com.finderbar.omnihub.modules.core.mapper.alias.PositionEntityMapper
import com.finderbar.omnihub.modules.core.model.PositionModel
import org.springframework.stereotype.Component

@Component
class PositionMapper : PositionEntityMapper() {
    override fun toModel(entity: PositionEntity): PositionModel {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: PositionCreateCommand): PositionEntity {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        entity: PositionEntity,
        model: PositionUpdateCommand
    ): PositionEntity {
        TODO("Not yet implemented")
    }
}