package com.example.parcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial.ui.theme.ParcialTheme
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
            //val viewModel: MainActivityViewModel = MainActivityViewModel()
            val navController = rememberNavController()
            val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
            val scope = rememberCoroutineScope()
            val navigationActions = remember(navController) {
                MainNavActions(navController, scope, drawerState)
            }
/*           MainNavGraph(
               startDestination = RootScreen.Splash.route,
               navController = navController,
               navigationActions = navigationActions
            )
*/
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