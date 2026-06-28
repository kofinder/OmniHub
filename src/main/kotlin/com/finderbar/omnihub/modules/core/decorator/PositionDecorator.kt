package com.finderbar.omnihub.modules.core.decorator

import com.finderbar.omnihub.core.decorator.AbstractDecorator
import com.finderbar.omnihub.modules.core.model.PositionModel
import org.springframework.stereotype.Component

@Component
class PositionDecorator: AbstractDecorator<PositionModel>() {
    override fun decorate(target: PositionModel): PositionModel {
        TODO("Not yet implemented")
    }
}