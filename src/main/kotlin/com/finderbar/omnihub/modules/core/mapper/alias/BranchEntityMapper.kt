package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.BranchCreateCommand
import com.finderbar.omnihub.modules.core.command.BranchUpdateCommand
import com.finderbar.omnihub.modules.core.entity.BranchEntity
import com.finderbar.omnihub.modules.core.model.BranchModel

typealias BranchEntityMapper = AbstractMapper<
    BranchEntity,
    BranchModel,
    BranchCreateCommand,
    BranchUpdateCommand
>