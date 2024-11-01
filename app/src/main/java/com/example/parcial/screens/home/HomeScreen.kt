package com.example.parcial.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcial.ui.theme.Green800

@Composable
fun HomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Green800)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "HOME SCREEN!",
            modifier = Modifier.background(Color.White)
        )
    }
//    Scaffold(
//        //bottomBar = { BottomNavigationBar(navController) },
//        //drawerContent = { DrawerContent(navController) }
//    ) {
//        // Main content of the Home screen
//    }
}