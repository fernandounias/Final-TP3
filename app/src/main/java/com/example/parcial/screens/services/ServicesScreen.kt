package com.example.parcial.screens.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
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
    val items = listOf(
        Pair("RECARGA SUBE", R.drawable.recarga_sube_icon_big),
        Pair("RECARGA CELULAR", R.drawable.recarga_celu_icon_big),
        Pair("PAGO DE SERVICIOS", R.drawable.pago_servicio_icon_big),
        Pair("DIRECT TV PREPAGO", R.drawable.direct_tv_icon_big)
    )

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { (title, icon) ->
            BotonServicios(
                title = title,
                image = painterResource(id = icon),
                onClick = { /* TODO */ }
            )
        }
    }
}

