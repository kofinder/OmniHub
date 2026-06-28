package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.modules.core.entity.CompanyEntity
import com.finderbar.omnihub.modules.core.model.CompanyModel

typealias CompanyEntityMapper = AbstractMapper<
    CompanyEntity,
    CompanyModel,
    CompanyCreateCommand,
    CompanyUpdateCommand
>