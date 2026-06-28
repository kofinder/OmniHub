package com.finderbar.omnihub.modules.core.facade.alias

import com.finderbar.omnihub.core.facade.AbstractCrudFacade
import com.finderbar.omnihub.modules.core.command.EmployeeCreateCommand
import com.finderbar.omnihub.modules.core.command.EmployeeUpdateCommand
import com.finderbar.omnihub.modules.core.model.EmployeeModel
import com.finderbar.omnihub.modules.core.query.EmployeeSearchQuery
import java.util.*

typealias EmployeeCrudFacade = AbstractCrudFacade<
    UUID,
    EmployeeModel,
    EmployeeSearchQuery,
    EmployeeCreateCommand,
    EmployeeUpdateCommand
>