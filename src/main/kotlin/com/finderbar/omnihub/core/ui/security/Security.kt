package com.finderbar.omnihub.core.ui.security

import com.finderbar.omnihub.core.ui.core.UIModel


abstract class Security<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : UIModel<M, C, CX>(model, config, context) {
    abstract fun hasAccess(): Boolean
}