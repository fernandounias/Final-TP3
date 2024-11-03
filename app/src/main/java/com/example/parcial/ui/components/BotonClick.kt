package com.example.parcial.ui.components

import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.R
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.DarkPurple
import com.example.parcial.ui.theme.Purple40
import com.example.parcial.ui.theme.Purple900


@Composable
fun BotonClick(
    texto: String,
    mostrarSwitch: Boolean = false,
    onSwitchChanged: (Boolean) -> Unit = {}
) {
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )

    val typography = Typography(
        bodyLarge = TextStyle(
            fontFamily = manropeBold,
            fontSize = 16.sp,
            lineHeight = 19.sp,
            color = Color(0xFF333333)
        )
    )

    var isSwitchChecked by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(Color.White)
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = texto,
            style = typography.bodyLarge,
            fontSize = 20.sp,
            color = DarkPurple
        )
        if (mostrarSwitch) {
            Switch(
                checked = isSwitchChecked,
                onCheckedChange = {
                    isSwitchChecked = it
                    onSwitchChanged(it)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = colorResource(id = R.color.green_800),
                    checkedTrackColor = colorResource(id = R.color.purple_200)
                ),
                modifier = Modifier.padding(end = 12.dp)

            )
        } else {
            Image(
                painter = painterResource(id = R.drawable.flecha_boton),
                contentDescription = "Icono del botón",
                modifier = Modifier
                    .width(30.dp)
                    .height(30.dp)
                    .padding(end = 3.dp)
            )
        }
    }
}

@Preview
@Composable
fun GridBotonesClickTarjeta(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(10.dp)
            )
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {
        BotonClick("Quiero mi tarjeta fisica", mostrarSwitch = true)
        HorizontalDivider(
            thickness = 2.dp,
            color = Color(0xFFE0E0E0)
        )

        BotonClick("Ya tengo mi tarjeta fisica", mostrarSwitch = true)
        Text(
            text = "Activa tu tarjeta para comnezar a usarla",
            fontSize = 20.sp,
            color = DarkPurple //cambiar
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GridBotonesClickProfile() {
    val opciones = listOf(
        "Mis datos",
        "Mi CVU",
        "Configuración",
        "Ayuda",
        "Términos y condiciones",
        "Cerrar sesión"
    )
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(10.dp)
            )
            .background(Color.White, shape = RoundedCornerShape(10.dp))
    ) {

        opciones.forEachIndexed { index, texto ->
            BotonClick(texto = texto, mostrarSwitch = false)
            if (index < opciones.size - 1) {
                HorizontalDivider(
                    thickness = 2.dp,
                    color = Color(0xFFE0E0E0)
                )
            }
        }
    }
    Spacer(modifier = Modifier.height(65.dp))
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(10.dp)
            )
            .background(Color.White, shape = RoundedCornerShape(10.dp))
        ){
        BotonClick("Dark Mode", mostrarSwitch = true)
    }
}


@Composable
fun BotonClickPreview() {
    Column {
        BotonClick("Mis datos", mostrarSwitch = false) // Con imagen
        Spacer(modifier = Modifier.height(16.dp))
        BotonClick("Dark Mode", mostrarSwitch = true) // Con Switch
    }
}


