package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.modules.core.command.CompanyCreateCommand
import com.finderbar.omnihub.modules.core.command.CompanyUpdateCommand
import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.model.CompanyModel
import com.finderbar.omnihub.modules.core.query.CompanySearchQuery
import java.util.UUID


typealias CompanyCrudFacade = AbstractCrudFacade<
    UUID,
    CompanyModel,
    CompanySearchQuery,
    CompanyCreateCommand,
    CompanyUpdateCommand
>