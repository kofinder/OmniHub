package com.finderbar.omnihub.core.ui.builder

import com.finderbar.omnihub.core.ui.page.Page

interface PageModelBuilder<P : Page<*, *, *>> {
    fun build(page: P): Map<String, Any>
}