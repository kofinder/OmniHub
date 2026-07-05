package com.finderbar.omnihub.modules.iam.ui.usecase

import com.finderbar.omnihub.core.ui.context.AppContext
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardConfig
import com.finderbar.omnihub.core.ui.layout.dashboard.DashboardModel
import com.finderbar.omnihub.core.ui.usecase.UseCase

class DashboardUseCase(
    model: DashboardModel,
    config: DashboardConfig,
    context: AppContext
) : UseCase<DashboardModel, DashboardConfig, AppContext>(
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