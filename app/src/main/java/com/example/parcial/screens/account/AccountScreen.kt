package com.example.parcial.screens.account

import VisualizadorSaldo
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.parcial.R
import com.example.parcial.ui.components.GridDeBotonesMiCuenta
import com.example.parcial.ui.components.TransactionsSection
import com.example.parcial.ui.theme.BackgroundScreens

@Composable
fun AccountScreen() {
    val accountViewModel: AccountViewModel = viewModel()
    val transactions = accountViewModel.transactions.observeAsState()
    val cvu = accountViewModel.cvu.observeAsState().value ?: "Cargando..."

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
            text = stringResource(id = R.string.account_title),
            fontFamily = manropeBold,
            color = colorResource(id = R.color.purple_dark),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )

        Spacer(modifier = Modifier.padding(15.dp))

        Column(
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = colorResource(id = R.color.light_gray),
                    shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp)
                )
                .background(Color.White)
                .padding(16.dp)
                .fillMaxWidth(0.93f)
                .height(153.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.padding(6.dp))

            VisualizadorSaldo(
                texto = stringResource(id = R.string.start_balance),
                saldo = 1322.78,
                textoSize = 36,
                saldoSize = 12
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.97f)
                    .height(1.dp)
                    .background(Color.Gray)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(fontFamily = manropeRegular)) {
                            append(stringResource(id = R.string.acc_id))
                        }
                        withStyle(style = SpanStyle(fontFamily = manropeBold)) {
                            append(" $cvu")
                        }
                    },
                    modifier = Modifier
                        .padding(start = 4.dp, bottom = 10.dp)
                        .weight(1f),
                    textAlign = TextAlign.Left,
                    color = colorResource(id = R.color.purple_dark),
                    fontSize = 16.sp
                )

                Text(
                    text = stringResource(id = R.string.acc_id_copy),
                    fontFamily = manropeBold,
                    color = colorResource(id = R.color.purple_dark),
                    modifier = Modifier
                        .height(25.dp)
                        .padding(end = 5.dp),
                    fontSize = 16.sp
                )
            }

        }

        Spacer(modifier = Modifier.padding(10.dp))
        Column(
            modifier = Modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GridDeBotonesMiCuenta()
        }
        TransactionsSection(transactions)
    }
}