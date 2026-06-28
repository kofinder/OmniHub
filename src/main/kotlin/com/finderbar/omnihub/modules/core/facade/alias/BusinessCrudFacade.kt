package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.command.BusinessCreateCommand
import com.finderbar.omnihub.modules.core.command.BusinessUpdateCommand
import com.finderbar.omnihub.modules.core.model.BusinessModel
import com.finderbar.omnihub.modules.core.query.BusinessSearchQuery
import java.util.*

typealias BusinessCrudFacade = AbstractCrudFacade<
    UUID,
    BusinessModel,
    BusinessSearchQuery,
    BusinessCreateCommand,
    BusinessUpdateCommand
>