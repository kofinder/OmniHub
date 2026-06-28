package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.OfficeModel
import org.springframework.stereotype.Component


@Component
class OfficeDecorator: AbstractDecorator<OfficeModel>() {
    override fun decorate(target: OfficeModel): OfficeModel {
        TODO("Not yet implemented")
    }
}