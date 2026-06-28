package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.EmployeeCreateCommand
import com.finderbar.omnihub.modules.core.command.EmployeeUpdateCommand
import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import com.finderbar.omnihub.modules.core.model.EmployeeModel


typealias EmployeeEntityMapper = AbstractMapper<
    EmployeeEntity,
    EmployeeModel,
    EmployeeCreateCommand,
    EmployeeUpdateCommand
>
