package com.finderbar.omnihub.core.ui.layout.dashboard

data class DashboardModel(
    var username: String = "",
    var notificationCount: Int = 0,
    var isRefreshing: Boolean = false,
    var isLoggedIn: Boolean = false
)