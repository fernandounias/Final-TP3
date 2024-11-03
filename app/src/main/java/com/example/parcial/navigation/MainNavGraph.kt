package com.example.parcial.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.parcial.MainNavActions
import com.example.parcial.screens.account.AccountScreen
import com.example.parcial.screens.card.CardScreen
import com.example.parcial.screens.home.HomeScreen
import com.example.parcial.screens.login.LoginScreen
import com.example.parcial.screens.services.ServicesScreen
import com.example.parcial.screens.services.ServicesSubeScreen
import com.example.parcial.screens.splash.SplashScreen

@Composable
fun MainNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController,
//    viewModel: MainActivityViewModel,
    startDestination: String = RootScreen.Splash.route,
    navigationActions: MainNavActions
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ){
        addSplashRoute(navController, navigationActions)
        addLoginRoute()
        addHomeRoute()
        addAccountRoute()
        addCardRoute()
        addServicesRoutes()
    }

}
fun NavGraphBuilder.addSplashRoute(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    composable(RootScreen.Splash.route) {
        SplashScreen(navController)
    }
}

fun NavGraphBuilder.addLoginRoute() {
    composable(RootScreen.Login.route) {
        LoginScreen()
    }
}

fun NavGraphBuilder.addHomeRoute() {
    composable(RootScreen.Home.route) {
        HomeScreen()
    }
}

fun NavGraphBuilder.addAccountRoute() {
    composable(RootScreen.Account.route) {
        AccountScreen()
    }
}
fun NavGraphBuilder.addCardRoute() {
    composable(RootScreen.Card.route) {
        CardScreen()
    }
}

fun NavGraphBuilder.addServicesRoutes() {
    navigation(
        route = RootScreen.Services.route,
        startDestination = LeafScreen.Services.route
    ) {
        composable(LeafScreen.Services.route) {
            ServicesScreen()
        }
        composable(LeafScreen.Sube.route) {
            ServicesSubeScreen()
        }
//        composable(LeafScreen.SubeSucces.route) {
//            ServicesSubeSuccesScreen(navController, navigationActions)
//        }

    }
}