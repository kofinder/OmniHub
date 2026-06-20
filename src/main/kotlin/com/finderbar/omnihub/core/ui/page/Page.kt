package com.finderbar.omnihub.core.ui.page

import com.finderbar.omnihub.core.ui.core.UIModel
import com.finderbar.omnihub.core.ui.layout.Layout


abstract class Page<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : UIModel<M, C, CX>(model, config, context) {

    abstract val layout: Layout<*, *, *>

    abstract val pageTitle: String
}