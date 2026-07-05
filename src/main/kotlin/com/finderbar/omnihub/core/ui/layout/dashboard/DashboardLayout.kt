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

    override val layoutName: String = "DashboardLayout"

    fun renderHeader(): String {
        return "Welcome ${model.username}"
    }

    fun renderNotifications(): String {
        return if (config.showNotifications) {
            "Notifications: ${model.notificationCount}"
        } else {
            "Notifications hidden"
        }
    }

    fun renderState(): String {
        return when {
            model.isRefreshing -> "Refreshing dashboard..."
            !model.isLoggedIn -> "Not logged in"
            else -> "Dashboard ready"
        }
    }
}