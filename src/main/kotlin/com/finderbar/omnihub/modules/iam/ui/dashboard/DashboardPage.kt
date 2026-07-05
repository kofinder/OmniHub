package com.finderbar.omnihub.modules.iam.ui.dashboard

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardConfig
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardLayout
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardModel
import com.finderbar.omnihub.core.ui.page.Page

class DashboardPage(
    model: DashboardModel,
    config: DashboardConfig,
    context: AppContext,
    override val layout: DashboardLayout,
    private val controller: DashboardController,
) : Page<DashboardModel, DashboardConfig, AppContext>(
    model,
    config,
    context
) {

    override val templatePath: String = ""

    override val pageTitle: String = "Dashboard"

    fun onLoad(username: String) {
        controller.loadDashboard(username)
    }

    fun onRefresh() {
        controller.refresh()
    }

    fun onLogout() {
        controller.logout()
    }

    fun renderPage(): String {
        return """
            ===== $pageTitle =====
            App: ${context.appName}

            ${layout.renderHeader()}
            ${layout.renderNotifications()}
            ${layout.renderState()}
        """.trimIndent()
    }
}