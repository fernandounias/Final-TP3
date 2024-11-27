package com.example.parcial.screens.home

import com.example.parcial.model.model.user.UserViewModelFactory
import VisualizadorSaldo
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial.R
import com.example.parcial.shared.infraestructure.RetrofitModule
import com.example.parcial.shared.infraestructure.users.UserRepository
import com.example.parcial.ui.components.BotonClick
import com.example.parcial.ui.components.GridDeBotonesInicio
import com.example.parcial.ui.components.TarjetaConBoton
import com.example.parcial.ui.theme.DarkPurple
import com.example.parcial.model.model.user.UserViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Preview(showBackground = true)
@Composable
fun HomeScreen() {
//    val userRepository = UserRepository(RetrofitModule.userServices)
//    val factory = UserViewModelFactory(userRepository)
//    val userViewModel: UserViewModel = viewModel(factory = factory)

    val userViewModel: UserViewModel = hiltViewModel()

    val userName by userViewModel.userName.collectAsState()

    LaunchedEffect(Unit) {
        userViewModel.fetchUser(2)
    }
    LazyColumn(
        modifier = Modifier
        .padding(start = 16.dp, end = 16.dp, top = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = if (userName != null) "\uD83D\uDC4B Hola $userName" else "Loading...",
                    fontSize = 18.sp,
                    fontFamily = manropeBold,
                    color = DarkPurple
                )
                Text(
                    text = "Último acceso: Mar 01, 2020 4:55 PM",
                    fontSize = 14.sp,
                    fontFamily = manropeRegular,
                    color = DarkPurple
                )
            }
        }
        item {
            TarjetaConBoton(
                numeroTarjeta = "1234567890123456",
                fechaVencimiento = "05/23",
            )
        }

        item { Spacer(modifier = Modifier.padding(4.dp)) }

        item {
            VisualizadorSaldo(
                texto = stringResource(id = R.string.start_balance),
                saldo = 1322.78,
                textoSize = 45,
                saldoSize = 12
            )
        }

        item { Spacer(modifier = Modifier.padding(4.dp)) }

        item {
            BotonClick(
                texto = stringResource(id = R.string.start_card_alert),
                subtitulo = stringResource(id = R.string.start_card_alert_link),
                isWarning = true
            )
        }

        item { Spacer(modifier = Modifier.padding(4.dp)) }

        item {
            GridDeBotonesInicio()
        }
    }
}

val manropeBold = FontFamily(
    Font(R.font.manrope_bold)
)

val manropeRegular = FontFamily(
    Font(R.font.manrope_regular)
)


