package com.example.parcial.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcial.R

@Composable
fun RoundCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Box(
        modifier = Modifier
            .clickable { onCheckedChange(!checked) }
            .size(30.dp)
            .background(
                color = if (checked) Color.Green else Color.Transparent,
                shape = CircleShape
            )
            .border(
                width = 2.dp,
                color = if (checked) Color.Green else Color.Gray,
                shape = CircleShape
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            painter = painterResource(id = if (checked) R.drawable.checkbox_checked else R.drawable.checkbox_unchecked),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}