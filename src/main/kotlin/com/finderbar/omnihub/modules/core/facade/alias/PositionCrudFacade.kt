package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.command.PositionCreateCommand
import com.finderbar.omnihub.modules.core.command.PositionUpdateCommand
import com.finderbar.omnihub.modules.core.model.PositionModel
import com.finderbar.omnihub.modules.core.query.PositionSearchQuery
import java.util.*


typealias PositionCrudFacade = AbstractCrudFacade<
    UUID,
    PositionModel,
    PositionSearchQuery,
    PositionCreateCommand,
    PositionUpdateCommand
>