package com.example.parcial.screens.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.components.BotonServicios
import com.example.parcial.ui.theme.BackgroundScreens

@Composable
fun ServicesScreen(
) {
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
            text = "Pago de servicios",
            fontFamily = manropeBold,
            color = colorResource(id = R.color.purple_dark),
            fontSize = 22.sp,
            modifier = Modifier
                .padding(top = 14.dp)
                .padding(bottom = 15.dp)
        )
        BotonServiciosGrid()
    }
}
@Preview
@Composable
fun BotonServiciosGrid() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            BotonServicios(
                title = "RECARGA SUBE",
                image = painterResource(id = R.drawable.recarga_sube_icon_big),
                onClick = { /*TODO*/ },

            )
            BotonServicios(
                title = "RECARGA CELULAR",
                image = painterResource(id = R.drawable.recarga_celu_icon_big),
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            BotonServicios(
                title = "PAGO DE SERVICIOS",
                image = painterResource(id = R.drawable.pago_servicio_icon_big)
            )
            BotonServicios(
                title = "DIRECT TV PREPAGO",
                image = painterResource(id = R.drawable.direct_tv_icon_big)
            )
        }
    }
}

