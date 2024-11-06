package com.example.parcial.ui.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.parcial.ui.theme.Purple900

//@Preview
@Composable
fun ClickableLink(
    text: String,
    align: String,
    onClick: () -> Unit
) {
    val textAlign = when (align.lowercase()) {
        "right" -> TextAlign.End
        "left" -> TextAlign.Start
        else -> TextAlign.Center
    }
    Text(
        text = text,
        style = TextStyle(
            color = Purple900,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium
        ),
        modifier = Modifier
            .clickable(onClick = onClick)
            .padding(start = 4.dp, end = 4.dp)
            .fillMaxWidth(),
        textAlign = textAlign
    )
}