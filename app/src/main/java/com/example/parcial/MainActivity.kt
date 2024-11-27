package com.example.parcial

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.parcial.navigation.LeafScreen
import com.example.parcial.navigation.MainNavGraph
import com.example.parcial.navigation.RootScreen
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.shared.BottomNavItem
import com.example.parcial.ui.AppTheme
import com.google.firebase.FirebaseApp
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val sharedPreferences = getSharedPreferences("app_prefs", Context.MODE_PRIVATE)
        val isDarkMode = sharedPreferences.getBoolean("dark_mode", false)

        setContent {
            val isDarkModeState = remember { mutableStateOf(isDarkMode) }

            AppTheme(isDarkModeState.value) {
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val navigationActions = remember(navController) {
                MainNavActions(navController, scope, drawerState)
            }
            ScaffoldContent(
                navController,
                navigationActions,
                sharedPreferences = sharedPreferences,
                isDarkModeState = isDarkModeState,
            )
            }
        }
    }
}

@Composable
fun ScaffoldContent(
    navController: NavHostController,
    navigationActions: MainNavActions,
    sharedPreferences: SharedPreferences,
    isDarkModeState: MutableState<Boolean>,
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
            navigationActions = navigationActions,
            sharedPreferences = sharedPreferences,
            isDarkModeState = isDarkModeState,
        )
    }
}