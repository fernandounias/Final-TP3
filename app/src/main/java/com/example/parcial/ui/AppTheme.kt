package com.example.parcial.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.parcial.screens.home.manropeBold
import com.example.parcial.ui.theme.DarkColors
import com.example.parcial.ui.theme.LightColors

val LocalColors = staticCompositionLocalOf { LightColors }

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {

    val colors = if (darkTheme) DarkColors else LightColors

    CompositionLocalProvider(LocalColors provides colors) {
        MaterialTheme(
            colorScheme = colors.colorScheme,
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
}
