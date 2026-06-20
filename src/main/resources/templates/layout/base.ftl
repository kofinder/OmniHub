
<#--
    KoffeeStrap Base Layout
    Master reusable layout

    Author: Ko Thein
    Created: 2026-05-01
-->

<#macro main>

<!DOCTYPE html>
<html lang="${locale!'en'}">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>
        <#if pageTitle??>
            ${pageTitle} | ${appName!'KoffeeStrap'}
        <#else>
            ${appName!'KoffeeStrap'}
        </#if>
    </title>

    <meta name="description" content="${pageDescription!'Enterprise UI Framework'}">
    <meta name="author" content="Ko Thein">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/vendor/bootstrap/css/bootstrap.min.css">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="/vendor/bootstrap-icons/bootstrap-icons.css">

    <!-- KoffeeStrap Core Styles -->
    <link rel="stylesheet" href="/css/koffeestrap-core.css">
    <link rel="stylesheet" href="/css/koffeestrap-components.css">
    <link rel="stylesheet" href="/css/koffeestrap-utilities.css">
    <link rel="stylesheet" href="/css/themes.css">

    <!-- Optional page styles -->
    <#if pageStyles??>
        <#list pageStyles as style>
            <link rel="stylesheet" href="${style}">
        </#list>
    </#if>

    <!-- Favicon -->
    <link rel="icon" type="image/x-icon" href="/favicon.ico">
</head>

<body class="${bodyClass!'cs-app'}">

    <!-- Global Loading Spinner -->
    <div id="cs-loader" class="cs-loader d-none">
        <div class="spinner-border text-primary" role="status">
            <span class="visually-hidden">Loading...</span>
        </div>
    </div>

    <!-- Flash Messages -->
    <#if flashMessage??>
        <div class="container mt-3">
            <div class="alert alert-${flashType!'info'} alert-dismissible fade show" role="alert">
                ${flashMessage}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </div>
    </#if>

    <!-- Main App Wrapper -->
    <div id="cs-app-wrapper" class="cs-app-wrapper">

        <!-- Header -->
        <#if headerTemplate??>
            <#include headerTemplate>
        </#if>

        <!-- Sidebar -->
        <#if sidebarTemplate??>
            <#include sidebarTemplate>
        </#if>

        <!-- Main Content -->
        <main id="cs-main-content" class="cs-main-content container-fluid py-4">
            <#nested>
        </main>

        <!-- Footer -->
        <#if footerTemplate??>
            <#include footerTemplate>
        </#if>

    </div>

    <!-- Bootstrap Bundle -->
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- KoffeeStrap Core Scripts -->
    <script src="/js/koffeestrap.js"></script>
    <script src="/js/forms.js"></script>
    <script src="/js/tables.js"></script>
    <script src="/js/dashboard.js"></script>

    <!-- Optional page scripts -->
    <#if pageScripts??>
        <#list pageScripts as script>
            <script src="${script}"></script>
        </#list>
    </#if>

    <!-- Inline Script -->
    <#if inlineScript??>
        <script>
            ${inlineScript}
        </script>
    </#if>

</body>
</html>

</#macro>
