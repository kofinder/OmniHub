package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.command.DepartmentCreateCommand
import com.finderbar.omnihub.modules.core.command.DepartmentUpdateCommand
import com.finderbar.omnihub.modules.core.model.DepartmentModel
import com.finderbar.omnihub.modules.core.query.DepartmentSearchQuery
import java.util.*


typealias DepartmentCrudFacade = AbstractCrudFacade<
    UUID,
    DepartmentModel,
    DepartmentSearchQuery,
    DepartmentCreateCommand,
    DepartmentUpdateCommand
>