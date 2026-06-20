package com.finderbar.omnihub.core.ui.extension

import com.finderbar.omnihub.core.ui.core.UIModel


abstract class Extension<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : UIModel<M, C, CX>(model, config, context) {
    abstract val extensionName: String
}