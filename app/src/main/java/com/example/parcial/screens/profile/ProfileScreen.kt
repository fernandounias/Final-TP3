package com.example.parcial.screens.profile

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.R
import com.example.parcial.shared.BottomNavItem
import com.example.parcial.ui.components.GridBotonesClick
import com.example.parcial.ui.theme.BackgroundScreens
import kotlinx.coroutines.delay

@Preview
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
                .padding(horizontal = 16.dp)
        ) {
            Spacer(modifier = Modifier.height(90.dp))

            // Imagen de perfil
            Box(
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.profile_img),
                    tint = Color.Unspecified,
                    contentDescription = "Profile Image",
                    modifier = Modifier
                        .size(80.dp)
                        .background(Color.Gray, shape = CircleShape)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "👋 Hola Mariana Belén",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(16.dp))
            GridBotonesClick()
        }
    }
}