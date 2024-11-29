package com.example.parcial.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import com.example.parcial.R
import com.example.parcial.ui.LocalColors
import com.example.parcial.ui.theme.Green800

@Composable
fun BottomNavBar(
    navController: NavHostController,
    navigationActions: MainNavActions,
    selectedItem: String
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Account,
        BottomNavItem.Card,
        BottomNavItem.Services,
        BottomNavItem.Menu
    )

    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        shadowElevation = 24.dp,
        tonalElevation = 24.dp,
        color = LocalColors.current.background,
        contentColor = LocalColors.current.background
    ) {
        NavigationBar(
            containerColor = LocalColors.current.inputBackground,
            modifier = Modifier
                .fillMaxWidth()
                .height(94.dp)
        ) {

            items.forEach { item ->
                val icon =
                    if (selectedItem == item.label) item.selectedIcon else item.unselectedIcon
                val isSelected = selectedItem == item.label

                NavigationBarItem(
                    modifier = Modifier.fillMaxWidth(),
                    icon = {
                        Box(
                            modifier = Modifier.fillMaxHeight(),
                            contentAlignment = Alignment.TopCenter
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Top,
                                modifier = Modifier
                                    .fillMaxHeight()
                            ) {
                                if (isSelected) {
                                    Box(
                                        modifier = Modifier
                                            .width(70.dp)
                                            .height(2.dp)
                                            .background(Green800)
                                    )

                                } else {
                                    Spacer(modifier = Modifier.height(2.dp))
                                }

                                Spacer(modifier = Modifier.height(6.dp))

                                Icon(
                                    painter = painterResource(id = icon),
                                    contentDescription = item.label,
                                    tint = if (!isSelected) LocalColors.current.tintW else Color.Unspecified,
                                    modifier = Modifier
                                        .size(28.dp)
                                        .padding(top = 6.dp)
                                )
                                Spacer(modifier = Modifier.height(6.dp))
                            }
                        }
                    },
                    selected = selectedItem == item.label,
                    onClick = {
                        when (item) {
                            is BottomNavItem.Home -> navigationActions.navigateToHome()
                            is BottomNavItem.Account -> navigationActions.navigateToAccount()
                            is BottomNavItem.Card -> navigationActions.navigateToCard()
                            is BottomNavItem.Services -> navigationActions.navigateToServices()
                            is BottomNavItem.Menu -> navigationActions.navigateToProfile()
                        }
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color.Transparent,
                        unselectedIconColor = Color.Transparent,
                        indicatorColor = Color.Transparent
                    )
                )
            }
        }
    }
}

sealed class BottomNavItem(val label: String, val unselectedIcon: Int, val selectedIcon: Int) {
    object Home :
        BottomNavItem("Home", R.drawable.home, R.drawable.home_selected)
    object Account :
        BottomNavItem("Account", R.drawable.movimientos, R.drawable.movimientos_selected)
    object Card :
        BottomNavItem("Card", R.drawable.tarjeta_credito, R.drawable.tarjeta_credito_selected)
    object Services :
        BottomNavItem("Services", R.drawable.wallet, R.drawable.wallet_selected)
    object Menu :
        BottomNavItem("Menu", R.drawable.menu, R.drawable.menu_selected)
}