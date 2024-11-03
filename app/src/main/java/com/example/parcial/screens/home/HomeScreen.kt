package com.example.parcial.screens.home

import VisualizadorSaldo
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.parcial.ui.theme.Green800
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.MainNavActions
import com.example.parcial.model.users.User
import com.example.parcial.screens.user.UserViewModel
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.shared.infraestructure.users.UserImpl
import com.example.parcial.ui.components.BotonConIcono
import com.example.parcial.ui.components.GridDeBotonesInicio
import com.example.parcial.ui.components.Tarjeta
import com.example.parcial.ui.theme.BackgroundScreens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Preview
@Composable
fun HomeScreen() {

        Column(modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 1.dp),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {

            Tarjeta(
                numeroTarjeta = "4957 **** ***** 5824",
                fechaVencimiento = "05/23",
                mostrarDatos = true
            )

            Spacer(modifier = Modifier.padding(8.dp))
            VisualizadorSaldo(
                texto = "SALDO DISPONIBLE",
                saldo = 1322.78,
                textoSize = 36,
                saldoSize = 12
            )
            Spacer(modifier = Modifier.padding(8.dp))

            GridDeBotonesInicio()

        }}
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

