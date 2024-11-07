package com.example.parcial.screens.splash

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.parcial.ui.theme.Green800
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.parcial.R
import com.example.parcial.MainNavActions
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Green800)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.group_1),
            contentDescription = "Splash Icon",
            modifier = Modifier.size(width = 257.dp, height = 36.dp)
        )

        LaunchedEffect(Unit) {
            delay(1800)
            navController.navigate("login_root"){
                popUpTo("splash") { inclusive = true }
            }
        }
    }
}