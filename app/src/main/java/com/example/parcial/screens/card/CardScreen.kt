package com.example.parcial.screens.card

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.components.GridBotonesClickTarjeta
import com.example.parcial.ui.components.TarjetaConBoton
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.LightGray

@Preview
@Composable
fun CardScreen() {
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
            text = stringResource(id = R.string.card_title),
            fontFamily = manropeBold,
            color = colorResource(id = R.color.purple_dark),
            fontSize = 18.sp,
            modifier = Modifier
                .padding(top = 16.dp)
        )
        Text(
            text = stringResource(id = R.string.card_virtual),
            fontFamily = manropeBold,
            fontSize = 13.sp,
            color = colorResource(id = R.color.purple_dark),
            modifier = Modifier
                .padding(top = 16.dp, start = 8.dp)
                .align(Alignment.Start)
        )
        TarjetaConBoton(
            "1234567890123456",
            "12/23",
            modifier = Modifier.padding(12.dp)
        )

        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth(),
            thickness = 1.dp,
            color = LightGray
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 25.dp)
                .padding(start = 8.dp)
        ) {
            Text(
                text = stringResource(id = R.string.card_help_info),
                fontSize = 16.sp,
                fontFamily = manropeRegular,
                fontWeight = FontWeight.W500,
                color = colorResource(id = R.color.purple_dark),
                modifier = Modifier
                    .padding(end = 10.dp)
            )
            Text(
                text = stringResource(id = R.string.card_physical),
                fontFamily = manropeBold,
                fontSize = 13.sp,
                color = colorResource(id = R.color.purple_dark),
                modifier = Modifier
                    .padding(top = 16.dp)
            )
        }
            GridBotonesClickTarjeta()
    }
}