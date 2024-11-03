package com.example.parcial.screens.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import com.example.parcial.R
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.ui.components.BotonClick
import com.example.parcial.ui.components.GridBotonesClickTarjeta
import com.example.parcial.ui.components.Tarjeta
import com.example.parcial.ui.components.TarjetaConBoton
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.LightGray

@Preview
@Composable
fun CardScreen() {
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )
    val manropeRegular = FontFamily(
        Font(R.font.manrope_regular)
    )

    Column(
        modifier = Modifier
            .background(BackgroundScreens)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Mi Tarjeta",
            fontFamily = manropeBold,
            color = colorResource(id = R.color.purple_dark),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = "TARJETA VIRTUAL",
            fontFamily = manropeBold,
            fontSize = 13.sp,
            color = colorResource(id = R.color.purple_dark),
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp)
                .align(Alignment.Start)
        )
        TarjetaConBoton("1234567890123456", "12/23")

        Divider(
            color = LightGray,
            thickness = 1.dp,
            modifier = Modifier
                .fillMaxWidth()
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp)
                .padding(start = 8.dp)
        ) {
            Text(
                text = "💡 ¿Sabías que podés pedir una tarjeta Mastercard física para utilizar directamente en los negocios que vos elijas?",
                fontSize = 16.sp,
                fontFamily = manropeRegular,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.purple_dark),
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = "TARJETA FÍSICA",
                fontFamily = manropeBold,
                fontSize = 13.sp,
                color = colorResource(id = R.color.purple_dark),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
            GridBotonesClickTarjeta()

    }
}