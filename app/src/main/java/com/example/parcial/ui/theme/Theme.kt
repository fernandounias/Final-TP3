package com.example.parcial.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

data class CustomColorScheme(
    val colorScheme: ColorScheme,
    val navBarColor: Color,
    val buttonColor: Color,
    val textTitles: Color,
    val text0: Color,
    val text: Color,
    val textSubTitles: Color,
    val background: Color,
    val backgroundBox: Color,
    val inputBorder: Color,
    val inputBackground: Color,
    val inputLabel: Color,
    val inputText: Color,
    val shadowIconInp: Color,
    val shadowIconG: Color,
    val iconColor: Color,
    val tintW: Color

)

val LightColors = CustomColorScheme(
    colorScheme = lightColorScheme(),
    navBarColor = Color.White,
    buttonColor = Purple900,
    textTitles = DarkPurpleDark,
    text0 = DarkPurple,
    text = Color.Black,
    textSubTitles = Color.Gray,
    background = Color.White,
    backgroundBox = LightGray,
    inputBorder = LightGray,
    inputBackground = Color.White,
    inputLabel = Color.Gray,
    inputText = LightGrayDark,
    shadowIconInp = Color.Transparent,
    shadowIconG = GreenL,
    iconColor = Purple900,
    tintW = Color.Unspecified
)

val DarkColors = CustomColorScheme(
    colorScheme = darkColorScheme(),
    navBarColor = LightGray,
    buttonColor = Green900,
    textTitles = Color.White,
    text0 = LightGray,
    text = Color.White,
    textSubTitles = LightGray,
    background = LightGrayDark,
    backgroundBox = LightGrayDark,
    inputBorder = Color.White,
    inputBackground = LGray,
    inputLabel = LightGray,
    inputText = Color.White,
    shadowIconInp = Color.White,
    shadowIconG = Green800,
    iconColor = Green800,
    tintW = Color.White
)

val DarkColorScheme = darkColorScheme(
    primary = Color.Black,
    onPrimary = Color.White,
    secondary = ButtonDisabled,
    onSecondary = Color.White,
    surface = Color.DarkGray,
    onSurface = Color.White,
    background = Color.DarkGray,
    onBackground = Color.White
)

val LightColorScheme = lightColorScheme(
    primary = Purple900,
    onPrimary = Color.White,
    secondary = Color(0xFF03DAC6),
    onSecondary = Color.White,
    surface = Color.White,
    onSurface = Color.Black,
    background = Color.White,
    onBackground = Color.Black
)
