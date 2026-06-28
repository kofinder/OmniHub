package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.BusinessCreateCommand
import com.finderbar.omnihub.modules.core.command.BusinessUpdateCommand
import com.finderbar.omnihub.modules.core.entity.BusinessEntity
import com.finderbar.omnihub.modules.core.model.BusinessModel

typealias BusinessEntityMapper = AbstractMapper<
    BusinessEntity,
    BusinessModel,
    BusinessCreateCommand,
    BusinessUpdateCommand
>