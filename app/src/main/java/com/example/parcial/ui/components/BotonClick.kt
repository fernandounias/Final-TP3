package com.example.parcial.ui.components

import androidx.compose.material3.Typography
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.KeyboardArrowRight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.R
import com.example.parcial.ui.theme.DarkPurple
import com.example.parcial.ui.theme.Warning


@Composable
fun BotonClick(
    texto: String,
    subtitulo: String? = null,
    mostrarSwitch: Boolean = false,
    onSwitchChanged: (Boolean) -> Unit = {},
    isWarning: Boolean= false
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
            .background(
                if (!isWarning) Color.White else Warning,
                shape = RoundedCornerShape(if (!isWarning) 0.dp else 10.dp)
            )
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = texto,
                style = typography.bodyLarge,
                fontSize = if (!isWarning) 20.sp else 12.sp,
                color = if (!isWarning) DarkPurple else Color.White
            )
            subtitulo?.let {
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = it,
                    style = TextStyle(
                        fontSize = if (!isWarning) 20.sp else 12.sp,
                        color = if (!isWarning) DarkPurple else Color.White,
                        textDecoration = if (!isWarning) TextDecoration.None else TextDecoration.Underline
                    )
                )
            }
        }
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
            Box(
                modifier = Modifier
                    .size(30.dp)
                    .background(
                        color = if (isWarning) Warning else colorResource(id = R.color.green_800),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Rounded.KeyboardArrowRight,
                    contentDescription = "Icono del botón",
                    modifier = Modifier
                        .size(16.dp),
                    tint = Color.White
                )
            }
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
        BotonClick("Quiero mi tarjeta fisica", mostrarSwitch = false)
        HorizontalDivider(
            thickness = 2.dp,
            color = Color(0xFFE0E0E0)
        )

        BotonClick("Ya tengo mi tarjeta fisica",subtitulo = "Activa tu tarjeta para comenzar a usarla", mostrarSwitch = false)

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


