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
        addLoginRoute(navController, navigationActions)
        addHomeRoute(navController, navigationActions)
        addAccountRoute(navController, navigationActions)
        addCardRoute(navController, navigationActions)
        addServicesRoutes(navController, navigationActions)
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

fun NavGraphBuilder.addLoginRoute(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    composable(RootScreen.Login.route) {
        LoginScreen(navController, navigationActions)
    }
}

fun NavGraphBuilder.addHomeRoute(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    composable(RootScreen.Home.route) {
        HomeScreen(navController, navigationActions)
    }
}

fun NavGraphBuilder.addAccountRoute(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    composable(RootScreen.Account.route) {
        AccountScreen(navController, navigationActions)
    }
}
fun NavGraphBuilder.addCardRoute(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    composable(RootScreen.Card.route) {
        CardScreen(navController, navigationActions)
    }
}

fun NavGraphBuilder.addServicesRoutes(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    navigation(
        route = RootScreen.Services.route,
        startDestination = LeafScreen.Services.route
    ) {
        composable(LeafScreen.Services.route) {
            ServicesScreen(navController, navigationActions)
        }
        composable(LeafScreen.Sube.route) {
            ServicesSubeScreen(navController, navigationActions)
        }
//        composable(LeafScreen.SubeSucces.route) {
//            ServicesSubeSuccesScreen(navController, navigationActions)
//        }

    }
}