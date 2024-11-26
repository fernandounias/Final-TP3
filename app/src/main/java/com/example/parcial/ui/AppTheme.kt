package com.example.parcial.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.parcial.screens.home.manropeBold
import com.example.parcial.ui.theme.DarkColorScheme
import com.example.parcial.ui.theme.LightColorScheme

@Composable
fun AppTheme(darkTheme: Boolean, content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(
        colorScheme = colors,
        typography = Typography(
            bodyLarge = TextStyle(
                fontFamily = manropeBold,
                fontSize = 16.sp,
                lineHeight = 19.sp,
                color = Color(0xFF333333)
            )
        ),
        content = content
    )
}