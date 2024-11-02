package com.example.parcial.navigation

sealed class RootScreen(val route: String) {
    object SingIn: RootScreen("singIn_root")
    object Home : RootScreen("home_root")
    object MiCuenta : RootScreen("miCuenta_root")
    object MiTarjeta : RootScreen("miTarjeta_root")
    object Servicios : RootScreen("servicios_root")
    object Perfil : RootScreen("perfil_root")
}

sealed class LeafScreen(val route: String) {
    object Sube : RootScreen("sube")
    object SubeSucces : RootScreen("subeSucces")
}