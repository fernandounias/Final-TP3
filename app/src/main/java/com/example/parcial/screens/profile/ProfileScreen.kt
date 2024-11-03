package com.example.parcial.screens.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.components.GridBotonesClickProfile
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.DarkPurple
import kotlinx.coroutines.delay

@Composable
fun ProfileScreen() {
    var isVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(200)
        isVisible = true
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInHorizontally(
            initialOffsetX = { -it },
            animationSpec = tween(durationMillis = 200)
    )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundScreens)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Mi Perfil",
                style = MaterialTheme.typography.titleSmall,
                fontSize = 22.sp,
                color = DarkPurple,
                modifier = Modifier.padding(bottom = 22.dp)
            )
            Icon(
                painter = painterResource(id = R.drawable.profile_img),
                tint = Color.Unspecified,
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(140.dp)
                    .background(Color.Gray, shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "👋 Hola Mariana Belén",
                style = MaterialTheme.typography.titleSmall,
                color = DarkPurple,
                fontSize = 22.sp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))
            GridBotonesClickProfile()
        }
    }
}