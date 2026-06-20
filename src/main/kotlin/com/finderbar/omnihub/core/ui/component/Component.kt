package com.finderbar.omnihub.core.ui.component

import com.finderbar.omnihub.core.ui.core.UIModel


abstract class Component<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : UIModel<M, C, CX>(model, config, context) {

    abstract fun renderId(): String
}