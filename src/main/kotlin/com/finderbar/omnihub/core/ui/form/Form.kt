package com.finderbar.omnihub.core.ui.form

import com.finderbar.omnihub.core.ui.component.Component


abstract class Form<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : Component<M, C, CX>(model, config, context) {

    abstract fun validate(): Boolean
    abstract fun fieldName(): String
}