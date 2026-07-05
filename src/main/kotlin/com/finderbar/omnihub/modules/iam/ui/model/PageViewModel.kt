package com.finderbar.omnihub.modules.iam.ui.model

data class PageViewModel(

    var appName: String = "Hilsa",

    var pageTitle: String = "",

    var authorName: String = "Ko Thein",

    var pageDescription: String = "Enterprise UI Framework",

    var locale: String = "en",

    var bodyClass: String = "cs-app",

    var pageStyles: List<String> = emptyList(),

    var pageScripts: List<String> = emptyList(),

    var flashMessage: String? = null,

    var flashType: String = "info"
)