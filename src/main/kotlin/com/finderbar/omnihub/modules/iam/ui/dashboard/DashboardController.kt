package com.finderbar.omnihub.modules.iam.ui.dashboard

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.usecase.Controller
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardConfig
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardModel

class DashboardController(
    model: DashboardModel,
    config: DashboardConfig,
    context: AppContext
) : Controller<DashboardModel, DashboardConfig, AppContext>(
    model,
    config,
    context
) {

    fun loadDashboard(username: String) {
        model.isLoggedIn = true
        model.username = username
        model.notificationCount = 3 // fake initial data
    }

    fun refresh() {
        model.isRefreshing = true

        // simulate refresh
        model.notificationCount += 1
        model.isRefreshing = false
    }

    fun clearNotifications() {
        model.notificationCount = 0
    }

    fun logout() {
        model.isLoggedIn = false
        model.username = ""
    }
}