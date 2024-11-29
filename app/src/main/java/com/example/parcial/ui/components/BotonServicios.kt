package com.example.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.LocalColors
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.DarkPurple
import com.example.parcial.ui.theme.Green800

@Composable
fun BotonServicios(
    title: String,
    image: Painter,
    onClick: () -> Unit = {}
) {
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )
    Button(
        onClick = onClick,
        modifier = Modifier
            .width(220.dp)
            .height(220.dp)
            .padding(10.dp)
            .border(
                width = 1.dp,
                color = Color(0xFFE0E0E0),
                shape = RoundedCornerShape(12.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = BackgroundScreens
        ),
        shape = RoundedCornerShape(12.dp),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 6.dp
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background( color = LocalColors.current.inputBackground)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .background( color = LocalColors.current.inputBackground)
                    .size(110.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.edge_icon_big_services),
                    contentDescription = "Circulo",
                    modifier = Modifier.size(100.dp),
                    colorFilter = ColorFilter.tint(LocalColors.current.shadowIconG)
                )
                Image(
                    painter = image,
                    contentDescription = "Service Icon",
                    modifier = Modifier.size(45.dp)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                fontFamily = manropeBold,
                fontSize = 12.sp,
                color = LocalColors.current.text,
            )
        }
    }
}

@Preview
@Composable
fun BotonServiciosPreview(){
    Column {
        BotonServicios(
            title = stringResource(id = R.string.services_btn_charge),
            image = painterResource(id = R.drawable.recarga_sube_icon_big)
        )
        BotonServicios(
            title = stringResource(id = R.string.services_btn_phone),
            image = painterResource(id = R.drawable.recarga_celu_icon_big),
        )
        BotonServicios(
            title = stringResource(id = R.string.services_btn_pay),
            image = painterResource(id = R.drawable.pago_servicio_icon_big)
        )
        BotonServicios(
            title = stringResource(id = R.string.services_btn_tv),
            image = painterResource(id = R.drawable.direct_tv_icon_big)
        )
    }

}