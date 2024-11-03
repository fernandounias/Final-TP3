package com.example.parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial.ui.theme.ParcialTheme
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.parcial.navigation.MainNavGraph
import com.example.parcial.MainNavActions
import com.example.parcial.screens.splash.SplashScreen
import androidx.activity.viewModels
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.parcial.navigation.RootScreen
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.shared.BottomNavItem

class MainActivity : ComponentActivity() {

//    private val viewModel: MainActivityViewModel by viewModels { MainActivityViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        // para usar la splash screen nativa
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

//            val viewModel: MainActivityViewModel = MainActivityViewModel()

            val navController = rememberNavController()
            val scope = rememberCoroutineScope()
            val navigationActions = remember(navController) {
                MainNavActions(navController, scope)
            }

//            MainNavGraph(
//                startDestination = RootScreen.Splash.route,
//                navController = navController,
//                navigationActions = navigationActions
//            )

            Scaffold(
                bottomBar = {
                    val currentDestination = navController.currentBackStackEntryAsState().value?.destination
                    val selectedItem = when (currentDestination?.route) {
                        RootScreen.Home.route -> BottomNavItem.Home.label
                        RootScreen.Account.route -> BottomNavItem.Account.label
                        RootScreen.Card.route -> BottomNavItem.Card.label
                        RootScreen.Services.route -> BottomNavItem.Services.label
                        else -> BottomNavItem.Home.label
                    }
                    BottomNavBar(
                        navController = navController,
                        navigationActions = navigationActions,
                        selectedItem = selectedItem
                    )
                }
            ){ innerPadding ->
                MainNavGraph(
                    startDestination = RootScreen.Splash.route,
                    navController = navController,
                    navigationActions = navigationActions,
                    modifier = Modifier.padding(innerPadding)
                )
            }


        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ParcialTheme {
        Greeting("Android")
    }
}