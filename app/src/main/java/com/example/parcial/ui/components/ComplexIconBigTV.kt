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
fun ComplexIconBigTV() {
    Box(
        modifier = Modifier.size(72.dp)
    ) {
        //el background para el icono de next
        Image(
            painter = painterResource(id = R.drawable.edge_icon_big_services),
            contentDescription = "background borde",
            modifier = Modifier.size(72.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.direct_tv_icon_big),
            contentDescription = "bus icon",
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.Center)
        )
    }
}