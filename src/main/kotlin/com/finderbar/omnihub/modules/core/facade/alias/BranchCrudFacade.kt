package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.command.BranchCreateCommand
import com.finderbar.omnihub.modules.core.command.BranchUpdateCommand
import com.finderbar.omnihub.modules.core.model.BranchModel
import com.finderbar.omnihub.modules.core.query.BranchSearchQuery
import java.util.*


typealias BranchCrudFacade = AbstractCrudFacade<
    UUID,
    BranchModel,
    BranchSearchQuery,
    BranchCreateCommand,
    BranchUpdateCommand
>