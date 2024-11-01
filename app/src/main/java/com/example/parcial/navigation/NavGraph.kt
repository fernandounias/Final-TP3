package com.example.parcial.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.parcial.screens.home.HomeScreen
import com.example.parcial.screens.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
//        navigation(
//            startDestination = "login",
//            route =
//        )
        composable("splash") { SplashScreen(navController) }
        composable("home") { HomeScreen(navController) }
//        composable("login") { LoginScreen(navController) }
//        composable("account") { AccountScreen() }
//        composable("card") { CardScreen() }
//        composable("services") { ServicesScreen() }
    }
}