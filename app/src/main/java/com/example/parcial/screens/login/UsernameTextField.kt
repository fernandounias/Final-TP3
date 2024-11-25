package com.example.parcial.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.theme.Red900

@Composable
fun UsernameTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label : String,
    isUsernameError : Boolean
) {

    TextField(
        modifier = Modifier
            .border(
                BorderStroke(
                    1.dp,
                    if (isUsernameError) Red900 else Color.LightGray
                    ),
                shape = RoundedCornerShape(3.dp)
            )
            .fillMaxWidth(),
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                color = if (isUsernameError) Red900 else Color.Gray
            )
        },
        textStyle = TextStyle(color = Color.Black, fontSize = 16.sp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Color.White,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
    )
}