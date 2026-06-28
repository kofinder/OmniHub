package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.BusinessModel
import org.springframework.stereotype.Component

@Component
class BusinessDecorator: AbstractDecorator<BusinessModel>() {
    override fun decorate(target: BusinessModel): BusinessModel {
        TODO("Not yet implemented")
    }
}