package com.example.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.R

@Preview
@Composable
fun ComplexIconNext() {
    Box(
        modifier = Modifier.size(25.dp)
    ) {
        //el background para el icono de next
        Image(
            painter = painterResource(id = R.drawable.icon_button_next_bkg),
            contentDescription = "background next",
            modifier = Modifier.size(25.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.icon_button_next_arrow),
            contentDescription = "arrow icon",
            modifier = Modifier
                .size(17.dp)
                .align(Alignment.Center)
        )
    }
}