package com.finderbar.omnihub.modules.utility

enum class SecurityEventType {
        LOGIN_SUCCESS,
        LOGIN_SUSPICIOUS,
        SECURITY_ALERT,
        LOGIN_FAILED,

        LOGOUT,

        TOKEN_REFRESH,

        API_CALL,
        API_ERROR,

        ROLE_ASSIGNED,
        PERMISSION_CHANGED
}