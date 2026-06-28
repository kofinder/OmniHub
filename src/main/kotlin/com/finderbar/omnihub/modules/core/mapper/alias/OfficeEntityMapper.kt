package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.entity.OfficeEntity
import com.finderbar.omnihub.modules.core.model.OfficeModel


typealias OfficeEntityMapper = AbstractMapper<
    OfficeEntity,
    OfficeModel,
    OfficeCreateCommand,
    OfficeUpdateCommand
>
