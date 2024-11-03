package com.example.parcial.screens.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.parcial.ui.theme.BackgroundScreens

@Preview
@Composable
fun ServicesScreen() {
    //this is for testing
    Box(
        modifier = Modifier
            .background(BackgroundScreens)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Services SCREEN!",
            modifier = Modifier.background(Color.White)
        )
//        BottomNavBar(navController, navigationActions)
    }

}
