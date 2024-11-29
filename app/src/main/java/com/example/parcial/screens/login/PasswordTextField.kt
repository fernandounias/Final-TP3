package com.example.parcial.screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.ui.LocalColors
import com.example.parcial.ui.theme.Green800
import com.example.parcial.ui.theme.Red900

@Composable
fun PasswordTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label : String,
    isPasswordError : Boolean
) {
    var passwordVisible by remember { mutableStateOf(false) }

    TextField(
        modifier = Modifier
            .border(
                BorderStroke(
                    1.dp,
                    if (isPasswordError) Red900 else LocalColors.current.inputBorder
                ),
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxWidth(),
        value = value,
        singleLine = true,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        onValueChange = onValueChange,
        label = {
            Text(
                color = LocalColors.current.inputLabel,
                text = label
            ) },
        trailingIcon = {
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                val icon = if (passwordVisible){
                    painterResource(id = R.drawable.hide_password_blue)
                }else{
                    painterResource(id = R.drawable.show_password_white)
                }
                Icon(painter = icon, contentDescription = "Toggle password visibility", tint = LocalColors.current.shadowIconInp,)
            }
        },
        textStyle = TextStyle(color = LocalColors.current.inputText, fontSize = 16.sp),
        colors = TextFieldDefaults.colors(
            focusedTextColor = LocalColors.current.inputText,
            unfocusedTextColor = LocalColors.current.inputText,
            focusedContainerColor = LocalColors.current.inputBackground,
            unfocusedContainerColor = LocalColors.current.inputBackground,
            cursorColor = Green800,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        shape = RoundedCornerShape(8.dp),
    )
}