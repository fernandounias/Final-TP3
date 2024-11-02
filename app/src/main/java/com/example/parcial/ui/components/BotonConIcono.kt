package com.example.parcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R

@Composable
fun BotonConIcono(
    iconoResId: Int,
    texto: String,
    shape: RoundedCornerShape // Forma personalizada para los bordes
) {
    Column(
        modifier = Modifier
            .background(Color.White, shape = shape)
            .border(1.dp, Color.LightGray, shape = shape)
            .padding(8.dp)
            .width(112.dp)
            .height(96.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = iconoResId),
            contentDescription = texto,
            tint = colorResource(R.color.green_800),
            modifier = Modifier.size(30.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = texto,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.purple_dark),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GridDeBotonesInicio() {
    Column {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            BotonConIcono(
                iconoResId = R.drawable.cargar_dinero,
                texto = stringResource(R.string.start_btn_add),
                shape = RoundedCornerShape(topStart = 16.dp)
            )
            BotonConIcono(
                iconoResId = R.drawable.extraer_dinero,
                texto = stringResource(R.string.start_btn_subtrack),
                shape = RoundedCornerShape(0.dp)
            )
            BotonConIcono(
                iconoResId = R.drawable.prestamos,
                texto = stringResource(R.string.start_btn_loan),
                shape = RoundedCornerShape(topEnd = 16.dp)
            )
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            BotonConIcono(
                iconoResId = R.drawable.recarga_sube,
                texto = stringResource(R.string.start_btn_charge),
                shape = RoundedCornerShape(bottomStart = 16.dp)
            )
            BotonConIcono(
                iconoResId = R.drawable.recarga_celu,
                texto = stringResource(R.string.start_btn_phone),
                shape = RoundedCornerShape(0.dp)
            )
            BotonConIcono(
                iconoResId = R.drawable.pago_servicio,
                texto = stringResource(R.string.start_btn_pay),
                shape = RoundedCornerShape(bottomEnd = 16.dp)
            )
        }
    }
}

@Composable
fun GridDeBotonesMiCuenta() {
    Column {
        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            BotonConIcono(
                iconoResId = R.drawable.cargar_dinero,
                texto = stringResource(R.string.start_btn_add),
                shape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp)
            )
            BotonConIcono(
                iconoResId = R.drawable.extraer_dinero,
                texto = stringResource(R.string.start_btn_subtrack),
                shape = RoundedCornerShape(0.dp)
            )
            BotonConIcono(
                iconoResId = R.drawable.prestamos,
                texto = stringResource(R.string.acc_btn_transfer),
                shape = RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GridDeBotonesInicioPreview() {
    GridDeBotonesInicio()
}

@Preview(showBackground = true)
@Composable
fun GridDeBotonesMiCuentaPreview() {
    GridDeBotonesMiCuenta()
}