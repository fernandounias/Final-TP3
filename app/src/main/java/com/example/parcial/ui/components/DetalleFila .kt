package com.example.parcial.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.theme.DarkPurple
import com.example.parcial.ui.theme.Green900
import com.example.parcial.ui.theme.LightGray
import com.example.parcial.ui.theme.Red900

@Composable
fun DetalleFila (
    fecha: String, descripcion: String, monto: Double, autorizacion: String, type: String, modifier: Modifier
) {

// @TODO AUGUSTO: cambiar el font family.
    val textColor = if (type == "credit") Green900 else Red900
    val formattedMonto = if (type == "credit") "+$%.2f".format(monto) else "-$%.2f".format(monto)
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )
    fun invertirFecha(fecha: String): String {
        val partes = fecha.split("-")
        return "${partes[2]}-${partes[1]}-${partes[0]}"
    }
    val customTextStyle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 19.6.sp,
        textAlign = TextAlign.Left
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
            .sizeIn(minWidth = 360.dp, minHeight = 56.dp)
            .padding(top = 2.dp, end = 12.dp, bottom = 2.dp),
    ) {
        Text(
            text = invertirFecha(fecha), style = customTextStyle, color = DarkPurple, fontFamily = manropeBold
        )
        Spacer(modifier = Modifier.weight(0.05f))
        Column {
            Text(
                text = descripcion,
                style = customTextStyle,
                color = DarkPurple,
                fontFamily = manropeBold,
                modifier = Modifier.width(180.dp)
            )
            Text(
                text = "Aut. $autorizacion",
                style = customTextStyle,
                color = DarkPurple,
                fontFamily = manropeBold
            )
        }
        Spacer(modifier = Modifier.weight(0.2f))
        Text(
            text = formattedMonto,
            style = customTextStyle,
            color = textColor,
            fontFamily = manropeBold
        )
    }
    HorizontalDivider(
        modifier = Modifier,
        color = LightGray
    )

}

@Preview(showBackground = true)
@Composable
fun DetalleFilaPreview() {
    DetalleFila(
        fecha = "19-03-20",
        descripcion = "Transferencia",
        monto = 20000.00,
        autorizacion = "Aut. 399954",
        type = "credit",
        modifier = Modifier.padding(8.dp)
    )
}