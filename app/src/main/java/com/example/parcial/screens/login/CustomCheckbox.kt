package com.example.parcial.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.parcial.R

//@Preview
@Composable
fun RoundCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
){
    var isFocused by remember { mutableStateOf(false) }
//    var checked = true
//    fun onCheckedChange(checked: Boolean){}

    Box(
        modifier = Modifier
            .focusable()
            .onFocusChanged { focusState -> isFocused = focusState.isFocused }
            .clickable { onCheckedChange(!checked) }
            .size(30.dp) // Size of the round checkbox
            .background(
                Color.Transparent,
//                if (checked) Color.Transparent else Color.White,
                shape = CircleShape
            )
            .border(
                2.dp,
                when {
                    checked -> Color.Transparent
                    isFocused -> Color.Transparent
//                    else -> Color.Gray
                    else -> Color.Transparent
                },
                shape = CircleShape
            ),
//            .clip(CircleShape), // Makes the box round
//            .background(if (checked) Color(0xFF00D563) else Color.Gray), // Checked color
        contentAlignment = Alignment.Center,
    ){
        FocusableCheckedIcon(iconFocus = R.drawable.checkbox_checked, iconChecked = R.drawable.checkbox_unchecked, null)
//        if (checked) {
//            FocusableCheckedIcon(iconFocus = R.drawable.checkbox_checked, iconChecked = R.drawable.checkbox_unchecked, null)
//        }
    }
}

@Composable
fun FocusableCheckedIcon(iconFocus: Int, iconChecked: Int, iconDefault: Int? ) {
    var isChecked by remember { mutableStateOf(false) }
    var isFocused by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .focusable()
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .clickable { isChecked = !isChecked } // Toggle checked state
    ) {
        val iconId = when {
            isChecked && isFocused -> iconChecked
            isChecked -> iconChecked
            isFocused -> iconChecked
            else -> null // Default icon
        }

        iconId?.let {
            Icon(
                painter = painterResource(id = it),
                contentDescription = null,
                tint = Color.White
            )
        }
    }
}