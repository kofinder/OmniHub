package com.finderbar.omnihub.ui.extension

import com.finderbar.omnihub.ui.core.UIModel


abstract class Extension<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : UIModel<M, C, CX>(model, config, context) {
    abstract val extensionName: String
}