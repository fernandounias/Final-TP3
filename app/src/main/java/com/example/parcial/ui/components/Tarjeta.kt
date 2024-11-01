package com.example.parcial.ui.components

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.theme.fontFamily

@Composable
fun TarjetaConBoton(
    numeroTarjeta: String,
    fechaVencimiento: String
) {
    var mostrarDatos by remember { mutableStateOf(false) }

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
                Color(0xFF442E83)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = if (mostrarDatos) "Ocultar datos" else "Mostrar datos",
                color = Color(0xFF442E83),
                fontWeight = FontWeight.Medium,
                fontFamily = fontFamily
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

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1.6f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0FD08B)
        ),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.waynimovil),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(55.dp),
                tint = Color.White
            )

            Text(
                text = numeroFormateado,
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = fontFamily,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(top = 90.dp)
            )

            Row(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = fechaVencimiento,
                    modifier = Modifier.padding(top = 10.dp),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = fontFamily
                )
                Spacer(modifier = Modifier.width(220.dp))
                Icon(
                    painter = painterResource(id = R.drawable.mc_symbol_1),
                    contentDescription = null,
                    modifier = Modifier.size(55.dp),
                    tint = Color.Unspecified
                )
            }
        }
    }
}

fun formatearNumeroTarjeta(numero: String): String {
    return numero.chunked(4).joinToString(" ")
}

fun ocultarNumeroTarjeta(numero: String): String {
    val grupos = numero.chunked(4)
    return "${grupos[0]} **** **** ${grupos[3]}"
}

@Preview(showBackground = true)
@Composable
fun TarjetaConBotonPreview() {
    TarjetaConBoton("1234567890123456", "12/23")
}