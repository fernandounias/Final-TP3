package com.example.parcial.screens.services

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.LocalColors
import com.example.parcial.ui.components.BotonServicios
import com.example.parcial.ui.components.DialogSubeConfirmacion
import com.example.parcial.ui.components.DialogSubeVerificar

@Preview(showBackground = true)
@Composable
fun ServicesScreen() {
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )
    Column(
        modifier = Modifier
            .background( color = LocalColors.current.background)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Pago de servicios",
            fontFamily = manropeBold,
            color = LocalColors.current.textTitles,
            fontSize = 20.sp,
            modifier = Modifier
                .padding(top = 16.dp)
                .padding(bottom = 15.dp)
        )
        BotonServiciosGrid()
    }
}

@Composable
fun BotonServiciosGrid() {
    val items = listOf(
        Pair("RECARGA SUBE", R.drawable.recarga_sube_icon_big),
        Pair("RECARGA CELULAR", R.drawable.recarga_celu_icon_big),
        Pair("PAGO DE SERVICIOS", R.drawable.pago_servicio_icon_big),
        Pair("DIRECT TV PREPAGO", R.drawable.direct_tv_icon_big)
    )
    var showFirstDialog by remember { mutableStateOf(false) }
    var showSecondDialog by remember { mutableStateOf(false) }

    if (showFirstDialog) {
        DialogSubeVerificar(
            title = "Cargar Sube",
            cardNumber = "6061 3580 2384 9041",
            amount = 200,
            onDismiss = { showFirstDialog = false },
            onConfirm = {
                showFirstDialog = false
                showSecondDialog = true
            }
        )
    }
    if (showSecondDialog) {
        DialogSubeConfirmacion(
            title = "Cargar Sube",
            onDismiss = { showSecondDialog = false },
            image = painterResource(id = R.drawable.ok_),
            msg = "Tu operacion se ha realizado con éxito"
        )
    }
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .background( color = LocalColors.current.background)
            .padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(items) { (title, icon) ->
            BotonServicios(
                title = title,
                image = painterResource(id = icon),
                onClick = {
                    if (title == "RECARGA SUBE") {
                        showFirstDialog = true
                    }
                }
            )
        }
    }
}

