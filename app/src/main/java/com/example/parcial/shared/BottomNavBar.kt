package com.example.parcial.shared

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.parcial.R

//@Preview
@Composable
fun BottomNavBar(
    navController: NavHostController,
    navigationActions: MainNavActions,
    selectedItem: String
){
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Account,
        BottomNavItem.Card,
        BottomNavItem.Services,
        BottomNavItem.Menu
    )
    NavigationBar( containerColor = Color.White){

        items.forEach {item ->
            val icon = if (selectedItem == item.label) item.selectedIcon else item.unselectedIcon

            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = item.label
                    ) },
                label = { Text(item.label) },
                selected = selectedItem == item.label,
                onClick = {
                    when (item) {
                        is BottomNavItem.Home -> navigationActions.navigateToHome()
                        is BottomNavItem.Account -> navigationActions.navigateToAccount()
                        is BottomNavItem.Card -> navigationActions.navigateToCard()
                        is BottomNavItem.Services -> navigationActions.navigateToServices()
                        is BottomNavItem.Menu -> navigationActions.openDrawer()
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground
                )
            )
        }

    }
}

sealed class BottomNavItem(val label: String, val unselectedIcon: Int, val selectedIcon: Int) {
    object Home : BottomNavItem("Home", R.drawable.home, R.drawable.home_selected)
    object Account : BottomNavItem("Account", R.drawable.movimientos, R.drawable.movimientos_selected)
    object Card : BottomNavItem("Card", R.drawable.tarjeta_credito, R.drawable.tarjeta_credito_selected)
    object Services : BottomNavItem("Services", R.drawable.wallet, R.drawable.wallet_selected)
    object Menu : BottomNavItem("Menu", R.drawable.menu, R.drawable.menu_selected)
}