package com.example.parcial

import androidx.compose.material3.DrawerState
import androidx.navigation.NavHostController
import com.example.parcial.navigation.LeafScreen
import com.example.parcial.navigation.RootScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainNavActions(
    navController: NavHostController,
    scope: CoroutineScope,
    drawerState: DrawerState
) {
    /// Drawer Actions
    val openDrawer: () -> Unit = {
        scope.launch {
            drawerState.open()
        }
    }

    val closeDrawer: () -> Unit = {
        scope.launch {
            drawerState.close()
        }
    }

    /// navigation actions:

    // mover acá la splashscreen navigation

    val navigateToLogin: () -> Unit = {
        navController.navigate(RootScreen.Login.route){
            scope.launch {
                drawerState.close()
            }
        }
    }
    val navigateToHome: () -> Unit = {
        navController.navigate(RootScreen.Home.route) {
            scope.launch {
                drawerState.close()
            }
//          popUpTo(RootScreen.Splash.route) { inclusive = true }
        }
    }
    val navigateToAccount: () -> Unit = {
        navController.navigate(RootScreen.Account.route){
            scope.launch {
                drawerState.close()
            }
        }
    }
    val navigateToCard: () -> Unit = {
        navController.navigate(RootScreen.Card.route){
            scope.launch {
                drawerState.close()
            }
        }
    }
    val navigateToServices: () -> Unit = {
        navController.navigate(LeafScreen.Services.route){
            scope.launch {
                drawerState.close()
            }
        }
    }
}