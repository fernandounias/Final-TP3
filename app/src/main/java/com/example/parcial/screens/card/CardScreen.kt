package com.example.parcial.screens.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import com.example.parcial.shared.BottomNavBar

@Composable
fun CardScreen(
    navController: NavHostController,
    navigationActions: MainNavActions
) {
    //this is for testing
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Card SCREEN!",
            modifier = Modifier.background(Color.Green)
        )
        BottomNavBar(navController, navigationActions)
    }
}