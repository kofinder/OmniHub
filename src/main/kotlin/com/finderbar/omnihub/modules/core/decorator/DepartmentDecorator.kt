package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.DepartmentModel
import org.springframework.stereotype.Component


@Component
class DepartmentDecorator: AbstractDecorator<DepartmentModel>() {
    override fun decorate(target: DepartmentModel): DepartmentModel {
        TODO("Not yet implemented")
    }
}