package com.finderbar.omnihub.core.ui.layout.dashboard

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.Layout

class DashboardLayout(
    model: DashboardModel,
    config: DashboardConfig,
    context: AppContext,
) : Layout<DashboardModel, DashboardConfig, AppContext>(
    model,
    config,
    context
) {

    override val templatePath: String = "DashboardLayout"

    override val layoutName: String = "layout/dashboard.ftl"

}