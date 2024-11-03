package com.example.parcial.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.theme.Purple900

//import com.example.parcial.ui.theme.fontFamily

@Composable
fun TarjetaConBoton(
    numeroTarjeta: String,
    fechaVencimiento: String
) {
    var mostrarDatos by remember { mutableStateOf(false) }
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Tarjeta(
            numeroTarjeta = numeroTarjeta,
            fechaVencimiento = fechaVencimiento,
            mostrarDatos = mostrarDatos
        )

        TextButton(onClick = { mostrarDatos = !mostrarDatos }) {
            Icon(
                painter = painterResource(
                    id = if (mostrarDatos) R.drawable.hide_password_blue else R.drawable.show_password_white
                ),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = Purple900
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (mostrarDatos) stringResource(id = R.string.start_hide) else stringResource(id = R.string.start_show),
                color = Purple900,
                fontWeight = FontWeight.Medium,
                fontFamily = manropeBold
            )
        }
    }
}

@Composable
fun Tarjeta(
    numeroTarjeta: String,
    fechaVencimiento: String,
    mostrarDatos: Boolean
) {
    val numeroFormateado = if (mostrarDatos) formatearNumeroTarjeta(numeroTarjeta) else ocultarNumeroTarjeta(numeroTarjeta)
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.6f),
        shape = RoundedCornerShape(16.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.tarjeta_background),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

            Icon(
                painter = painterResource(id = R.drawable.waynimovil),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(16.dp)
                    .padding(end = 10.dp)
                    .size(60.dp),
                tint = Color.White
            )

            Text(
                text = numeroFormateado,
                color = Color.White,
                fontSize = 23.sp,
                fontFamily = manropeBold,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(top = 90.dp)
                    .padding(start = 20.dp)
            )

            Row(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = fechaVencimiento,
                    modifier = Modifier.padding(start = 20.dp)
                        .padding(bottom = 10.dp),
                    color = Color.White,
                    fontSize = 23.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = manropeBold
                )
                Spacer(modifier = Modifier.width(190.dp))
                Icon(
                    painter = painterResource(id = R.drawable.mc_symbol_1),
                    contentDescription = null,
                    modifier = Modifier.size(60.dp)
                        .padding(bottom = 20.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}

fun formatearNumeroTarjeta(numero: String): String {
    val cleanedNumero = numero.replace(" ", "")
    val format = cleanedNumero.chunked(4).joinToString(" ")
    return format
}

fun ocultarNumeroTarjeta(numero: String): String {
    val cleanedNumero = numero.filter { it.isDigit() }
    val grupos = cleanedNumero.chunked(4)
    val format = "${grupos.getOrElse(0) { "" }} **** **** ${grupos.getOrElse(3) { "" }}"
    return format
}

@Preview(showBackground = true)
@Composable
fun TarjetaConBotonPreview() {
    TarjetaConBoton("1234567890123456", "12/23")
}