package com.finderbar.omnihub.modules.core.mapper

import com.finderbar.omnihub.modules.core.command.DepartmentCreateCommand
import com.finderbar.omnihub.modules.core.command.DepartmentUpdateCommand
import com.finderbar.omnihub.modules.core.entity.DepartmentEntity
import com.finderbar.omnihub.modules.core.mapper.alias.CompanyEntityMapper
import com.finderbar.omnihub.modules.core.mapper.alias.DepartmentEntityMapper
import com.finderbar.omnihub.modules.core.model.DepartmentModel
import org.springframework.stereotype.Component


@Component
class DepartmentMapper : DepartmentEntityMapper() {
    override fun toModel(entity: DepartmentEntity): DepartmentModel {
        TODO("Not yet implemented")
    }

    override fun toEntity(model: DepartmentCreateCommand): DepartmentEntity {
        TODO("Not yet implemented")
    }

    override fun updateEntity(
        entity: DepartmentEntity,
        model: DepartmentUpdateCommand
    ): DepartmentEntity {
        TODO("Not yet implemented")
    }

}