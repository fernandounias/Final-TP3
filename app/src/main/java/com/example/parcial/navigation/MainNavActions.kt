package com.example.parcial.navigation

import androidx.compose.material3.DrawerState
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch


class MainNavActions(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {

    val navigateToHome: () -> Unit = {
        navController.navigate(RootScreen.Home.route) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToSingIn: () -> Unit = {
        navController.navigate(RootScreen.SingIn.route) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToMiCuenta: () -> Unit = {
        navController.navigate(RootScreen.MiCuenta.route) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToMiTarjeta: () -> Unit = {
        navController.navigate(RootScreen.MiTarjeta.route) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToServicios: () -> Unit = {
        navController.navigate(RootScreen.Servicios.route) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigateToPerfil: () -> Unit = {
        navController.navigate(RootScreen.Perfil.route) {
            scope.launch {
                drawerState.close()
            }
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}