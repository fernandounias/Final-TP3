package com.example.parcial.ui.components

import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.Composable
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
fun Tarjeta() {


    Card (
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .aspectRatio(1.6f),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor =  Color(0xFF0FD08B),
        ),
    ){

        Box (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            Icon(
                painter = painterResource(id = R.drawable.waynimovil),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 7.dp)
                    .align(Alignment.TopEnd)
                    .size(55.dp),
                tint = Color.White
            )

            Text(
                text = "4957 **** **** 5824",
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
            ){
                Text(
                    modifier = Modifier.padding(
                        top = 15.dp,
                    ),
                    text = "05/23",
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium,
                    fontFamily = fontFamily
                )
                Spacer(modifier = Modifier.width(220.dp)) // Aumenta el espaciado entre el texto y el ícono
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

@Preview(showBackground = true)
@Composable
fun TarjetaPreview() {
    Tarjeta()
}