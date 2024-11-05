package com.example.parcial.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.parcial.MainNavActions
import com.example.parcial.screens.account.AccountScreen
import com.example.parcial.screens.card.CardScreen
import com.example.parcial.screens.home.HomeScreen
import com.example.parcial.screens.login.LoginScreen
import com.example.parcial.screens.profile.ProfileScreen
import com.example.parcial.screens.services.ServicesScreen
import com.example.parcial.screens.splash.SplashScreen
import kotlinx.coroutines.CoroutineScope

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
        addSplashRoute(navController)
        addLoginRoute(navigationActions)
        addHomeRoute()
        addAccountRoute()
        addCardRoute()
        addServicesRoutes()
        addPerfilRoute()
    }

}
fun NavGraphBuilder.addSplashRoute(
    navController: NavHostController
) {
    composable(RootScreen.Splash.route) {
        SplashScreen(navController)
    }
}

fun NavGraphBuilder.addLoginRoute(
    navigationActions: MainNavActions,
) {
    composable(RootScreen.Login.route) {
//        LoginScreen(navigationActions)
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
fun NavGraphBuilder.addPerfilRoute(){
    composable(RootScreen.Profile.route){
        ProfileScreen()
    }
}
fun NavGraphBuilder.addServicesRoutes() {
    composable(LeafScreen.Services.route) {
        ServicesScreen()
    }
}