package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.command.OfficeCreateCommand
import com.finderbar.omnihub.modules.core.command.OfficeUpdateCommand
import com.finderbar.omnihub.modules.core.model.OfficeModel
import com.finderbar.omnihub.modules.core.query.OfficeSearchQuery
import java.util.*

typealias OfficeCrudFacade = AbstractCrudFacade<
    UUID,
    OfficeModel,
    OfficeSearchQuery,
    OfficeCreateCommand,
    OfficeUpdateCommand
>