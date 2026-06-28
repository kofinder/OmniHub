package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.EmployeeCreateCommand
import com.finderbar.omnihub.modules.core.command.EmployeeUpdateCommand
import com.finderbar.omnihub.modules.core.entity.EmployeeEntity
import com.finderbar.omnihub.modules.core.mapper.alias.EmployeeEntityMapper
import com.finderbar.omnihub.modules.core.model.EmployeeModel
import org.springframework.stereotype.Component


@Component
class EmployeeMapper : EmployeeEntityMapper() {
    override fun toModel(entity: EmployeeEntity): EmployeeModel {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: EmployeeCreateCommand): EmployeeEntity {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        entity: EmployeeEntity,
        model: EmployeeUpdateCommand
    ): EmployeeEntity {
        TODO("Not yet implemented")
    }
}