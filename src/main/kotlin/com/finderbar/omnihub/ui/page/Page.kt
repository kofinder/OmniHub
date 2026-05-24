package com.finderbar.omnihub.ui.page

import com.finderbar.omnihub.ui.core.UIModel
import com.finderbar.omnihub.ui.layout.Layout


abstract class Page<M, C, CX>(
    model: M,
    config: C,
    context: CX
) : UIModel<M, C, CX>(model, config, context) {

    abstract val layout: Layout<*, *, *>

    abstract val pageTitle: String
}