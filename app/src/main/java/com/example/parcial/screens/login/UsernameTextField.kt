package com.example.parcial.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.ui.LocalColors
import com.example.parcial.ui.theme.Green800
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
                    if (isUsernameError) Red900 else LocalColors.current.inputBorder
                    ),
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth(),
        value = value,
        singleLine = true,
        onValueChange = onValueChange,
        label = {
            Text(
                label,
                color = if (isUsernameError) Red900 else LocalColors.current.inputLabel
            )
        },
        textStyle = TextStyle(color = LocalColors.current.inputText, fontSize = 16.sp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = LocalColors.current.inputText,
            unfocusedTextColor = LocalColors.current.inputText,
            focusedContainerColor = LocalColors.current.inputBackground,
            unfocusedContainerColor = LocalColors.current.inputBackground,
            cursorColor = Green800,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
    )
}