package com.example.parcial.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcial.ui.theme.Green800
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.MainNavActions
import com.example.parcial.model.users.User
import com.example.parcial.screens.user.UserViewModel
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.shared.infraestructure.users.UserImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Preview
@Composable
fun HomeScreen() {
    Box(
        modifier = Modifier
            .background(Green800)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
        Text(
            text = "HOME SCREEN!",
            modifier = Modifier.background(Color.White)
        )
        Hola()
//        BottomNavBar(navController, navigationActions)

        }
    }

//    Scaffold(
//        //bottomBar = { BottomNavigationBar(navController) },
//        BottomNavBar(navController, navigationActions)
//        //drawerContent = { DrawerContent(navController) }
//    ) {
//        // Main content of the Home screen
//    }
}

@Composable
fun Hola(){
    var miEstado by remember { mutableStateOf("Hola") }
Log.d("hola",miEstado)

    Column {
//
        SimpleUserTest()
    }


}
@Composable
fun SimpleUserTest() {
    var user by remember { mutableStateOf<User?>(null) }

    LaunchedEffect(Unit) {
        val userImpl = UserImpl()
        user = withContext(Dispatchers.IO) {
            userImpl.getUser(7)
        }
    }

    if (user == null) {
        Text(text = "Loading...")
    } else {
        Text(text = "User: ${user?.username}", fontSize = 24.sp)
        Text(text = "User: ${user?.name?.firstName}", fontSize = 24.sp)
        Text(text = "User: ${user?.name?.lastName}", fontSize = 24.sp)


    }
}
