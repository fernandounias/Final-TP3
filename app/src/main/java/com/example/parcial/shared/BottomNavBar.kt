package com.example.parcial.shared

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview

//import androidx.compose.material3.BottomNavigation
//import androidx.compose.material3.BottomNavigationItem

//@Preview
@Composable
fun BottomNavBar(
    navController: NavHostController,
    navigationActions: MainNavActions
){

    Column {
        Button(onClick = navigationActions.navigateToHome) {
                Text("Inicio")
        }
        Button(onClick = navigationActions.navigateToLogin) {
            Text("Login")
        }
        Button(onClick = navigationActions.navigateToCard) {
            Text("Mi Tarjeta")
        }
        Button(onClick = navigationActions.navigateToAccount) {
            Text("Mi Cuenta")
        }
        Button(onClick = navigationActions.navigateToServices) {
            Text("Pago de servicios")
        }
    }

}