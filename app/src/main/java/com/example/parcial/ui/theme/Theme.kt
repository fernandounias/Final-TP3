package com.example.parcial.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle

val DarkColorScheme = darkColorScheme(
    primary = Green800,
    onPrimary = Color.White,
    secondary = ButtonDisabled,
    onSecondary = Color.Black,

    surface = Color.White,
    onSurface = Color.Black
)

val LightColorScheme = lightColorScheme(
    primary = Purple900,
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.White,

    surface = Color.White,
    onSurface = Color.White

)

@Composable
fun ParcialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(
            bodyMedium = TextStyle(
                color = Color.Black
            )
        ),
        content = content
    )
}