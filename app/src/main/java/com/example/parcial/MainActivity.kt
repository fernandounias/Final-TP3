package com.example.parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.parcial.navigation.MainNavGraph
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcial.navigation.RootScreen
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parcial.navigation.LeafScreen
import com.example.parcial.screens.login.LoginViewModel
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.shared.BottomNavItem
import com.example.parcial.shared.infraestructure.Auth.AuthRepository
import com.google.firebase.FirebaseApp
import com.example.parcial.screens.login.LoginViewModelFactory
import com.example.parcial.shared.infraestructure.RetrofitModule
import androidx.activity.viewModels

class MainActivity : ComponentActivity() {


    private lateinit var authRepository: AuthRepository

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(RetrofitModule.authServices)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        FirebaseApp.initializeApp(this)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val navigationActions = remember(navController) {
                MainNavActions(navController, scope, drawerState)
            }
            ScaffoldContent(navController, navigationActions)
        }
    }
}

@Composable
fun ScaffoldContent(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    Scaffold(
        bottomBar = {
            val currentDestination =
                navController.currentBackStackEntryAsState().value?.destination
            if (currentDestination?.route != RootScreen.Splash.route && currentDestination?.route != RootScreen.Login.route) {
                val selectedItem = when (currentDestination?.route) {
                    RootScreen.Home.route -> BottomNavItem.Home.label
                    RootScreen.Account.route -> BottomNavItem.Account.label
                    RootScreen.Card.route -> BottomNavItem.Card.label
                    LeafScreen.Services.route -> BottomNavItem.Services.label
                    RootScreen.Profile.route -> BottomNavItem.Menu.label
                    else -> BottomNavItem.Home.label
                }
                BottomNavBar(
                    navController = navController,
                    navigationActions = navigationActions,
                    selectedItem = selectedItem
                )
            }
        }
    ) { innerPadding ->
        MainNavGraph(
            startDestination = RootScreen.Splash.route,
            navController = navController,
            modifier = Modifier.padding(innerPadding),
            navigationActions = navigationActions
        )
    }
}