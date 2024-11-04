package com.example.parcial.screens.home

import VisualizadorSaldo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.R
import com.example.parcial.ui.components.BotonClick
import com.example.parcial.ui.components.GridDeBotonesInicio
import com.example.parcial.ui.components.TarjetaConBoton

@Preview
@Composable
fun HomeScreen() {

    Column(
        modifier = Modifier
            .padding(16.dp),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {

        TarjetaConBoton(
            numeroTarjeta = "4957 **** ***** 5824",
            fechaVencimiento = "05/23",
        )

        Spacer(modifier = Modifier.padding(4.dp))

        VisualizadorSaldo(
            texto = stringResource(id = R.string.start_balance),
            saldo = 1322.78,
            textoSize = 36,
            saldoSize = 12
        )

        Spacer(modifier = Modifier.padding(4.dp))

        BotonClick(
            texto = stringResource(id = R.string.start_card_alert), subtitulo = stringResource(
                id = R.string.start_card_alert_link
            ), isWarning = true
        )

        Spacer(modifier = Modifier.padding(4.dp))

        GridDeBotonesInicio()
    }
}

//@Composable
//fun SimpleUserTest() {
//    var user by remember { mutableStateOf<User?>(null) }
//
//    LaunchedEffect(Unit) {
//        val userImpl = UserImpl()
//        user = withContext(Dispatchers.IO) {
//            userImpl.getUser(7)
//        }
//    }
//
//    if (user == null) {
//        Text(text = "Loading...")
//    } else {
//        Text(text = "User: ${user?.username}", fontSize = 24.sp)
//        Text(text = "User: ${user?.name?.firstName}", fontSize = 24.sp)
//        Text(text = "User: ${user?.name?.lastName}", fontSize = 24.sp)
//
//
//    }

