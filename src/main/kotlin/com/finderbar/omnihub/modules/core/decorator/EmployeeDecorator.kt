package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.EmployeeModel
import org.springframework.stereotype.Component


@Component
class EmployeeDecorator: AbstractDecorator<EmployeeModel>() {
    override fun decorate(target: EmployeeModel): EmployeeModel {
        TODO("Not yet implemented")
    }
}