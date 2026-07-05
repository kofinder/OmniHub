package com.finderbar.omnihub.modules.iam.ui.page

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardConfig
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardLayout
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardModel
import com.finderbar.omnihub.core.ui.page.Page
import com.finderbar.omnihub.modules.iam.ui.usecase.DashboardUseCase

class DashboardPage(
    model: DashboardModel,
    config: DashboardConfig,
    context: AppContext,
    override val layout: DashboardLayout,
    private val controller: DashboardUseCase,
) : Page<DashboardModel, DashboardConfig, AppContext>(
    model,
    config,
    context
) {

    override val templatePath: String = ""

    override val pageTitle: String = "Dashboard"
}