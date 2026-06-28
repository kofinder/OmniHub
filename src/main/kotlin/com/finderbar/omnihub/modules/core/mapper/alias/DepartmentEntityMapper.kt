package com.finderbar.omnihub.modules.core.mapper.alias

import com.finderbar.omnihub.core.mapper.AbstractMapper
import com.finderbar.omnihub.modules.core.command.DepartmentCreateCommand
import com.finderbar.omnihub.modules.core.command.DepartmentUpdateCommand
import com.finderbar.omnihub.modules.core.entity.DepartmentEntity
import com.finderbar.omnihub.modules.core.model.DepartmentModel


typealias DepartmentEntityMapper = AbstractMapper<
    DepartmentEntity,
    DepartmentModel,
    DepartmentCreateCommand,
    DepartmentUpdateCommand
>
