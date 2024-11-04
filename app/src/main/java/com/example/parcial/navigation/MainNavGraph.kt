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
import com.example.parcial.screens.profile.ProfileScreen
import com.example.parcial.screens.services.ServicesScreen
import com.example.parcial.screens.services.ServicesSubeScreen
import com.example.parcial.screens.splash.SplashScreen
import com.example.parcial.screens.user.UserViewModel

@Composable
fun MainNavGraph(
    startDestination: String,
    navController: NavHostController,
    navigationActions: MainNavActions,
    userViewModel: UserViewModel, // Recibe UserViewModel
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        addSplashRoute(navController, navigationActions)
        addLoginRoute()
        addHomeRoute(userViewModel = userViewModel)
        addAccountRoute()
        addCardRoute()
        addServicesRoutes()
        addPerfilRoute()
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

fun NavGraphBuilder.addHomeRoute(userViewModel: UserViewModel) {
    composable(RootScreen.Home.route) {
        HomeScreen(userViewModel = userViewModel)
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
fun NavGraphBuilder.addPerfilRoute(){
    composable(RootScreen.Profile.route){
        ProfileScreen()
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