package com.jeetsrpr.mindsync.ui.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen("welcome")
    object Permissions : Screen("permissions")
    object ProfileSetup : Screen("profile_setup")
    object GmailConnect : Screen("gmail_connect")
    object Dashboard : Screen("dashboard")
    object Chat : Screen("chat")
    object Notifications : Screen("notifications")
    object Communications : Screen("communications")
    object Profile : Screen("profile")
    object Settings : Screen("settings")
}
