package com.example.parcial.navigation

sealed class RootScreen(val route: String) {
    object Splash : RootScreen("splash")
    object Login: RootScreen("login_root")
    object Home : RootScreen("home_root")
    object Account : RootScreen("account_root")
    object Card : RootScreen("card_root")
    object Services : RootScreen("services_root")
    object Profile : RootScreen("perfil_root")
}

sealed class LeafScreen(val route: String) {
    object Services : LeafScreen("services")
    object Sube : LeafScreen("services_sube")
    object SubeSucces : LeafScreen("services_subeSucces")
}