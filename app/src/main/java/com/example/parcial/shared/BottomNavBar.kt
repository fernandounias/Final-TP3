package com.example.parcial.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//import androidx.compose.material3.BottomNavigation
//import androidx.compose.material3.BottomNavigationItem

//@Preview
@Composable
fun BottomNavBar(
    navController: NavHostController,
    navigationActions: MainNavActions
){
    Box(
        modifier = Modifier
//            .align(Alignment.BottomCenter)
            .fillMaxWidth()
            .height(200.dp)
    ){
        Row{
            Button(onClick = navigationActions.navigateToHome) {
                    Text("home")
            }
            Button(onClick = navigationActions.navigateToLogin) {
                Text("Login")
            }
            Button(onClick = navigationActions.navigateToCard) {
                Text("T")
            }
            Button(onClick = navigationActions.navigateToAccount) {
                Text("C")
            }
            Button(onClick = navigationActions.navigateToServices) {
                Text("S")
            }
        }

    }

}