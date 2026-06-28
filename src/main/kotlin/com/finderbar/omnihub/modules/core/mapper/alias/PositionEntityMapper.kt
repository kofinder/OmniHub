package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.entity.PositionEntity
import com.finderbar.omnihub.modules.core.model.PositionModel

typealias PositionEntityMapper = AbstractMapper<
    PositionEntity,
    PositionModel,
    PositionCreateCommand,
    PositionUpdateCommand
>
