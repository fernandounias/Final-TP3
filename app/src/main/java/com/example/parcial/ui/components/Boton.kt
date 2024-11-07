package com.example.parcial.ui.components

import androidx.compose.foundation.Image
import com.example.parcial.R
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.parcial.ui.theme.ButtonContentColor
import com.example.parcial.ui.theme.ButtonDisabled
import com.example.parcial.ui.theme.ButtonHover
import com.example.parcial.ui.theme.ButtonPressed
import com.example.parcial.ui.theme.Purple900

@Composable
fun Boton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,//TODO ajustar
    iconPosition: BtnIconPosition = BtnIconPosition.None
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val isPressed by interactionSource.collectIsPressedAsState()
    var isFocused by remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }
    val manropeBold = FontFamily(
        Font(R.font.manrope_bold)
    )

    val icon = painterResource(id = R.drawable.arrow_btn)

    val backgroundColor = when {
        !isEnabled -> ButtonDisabled
        isPressed -> ButtonPressed
        isHovered -> ButtonHover
        else -> Purple900
    }

    val focusBorderColor = Color(56, 45, 113, 50)
    Box(
        modifier = Modifier
            .width(336.dp)
            .height(48.dp)
            .focusRequester(focusRequester)
            .hoverable(interactionSource = interactionSource)
            .onFocusEvent { focusState ->
                isFocused = focusState.isFocused
            }
            .then(
                if (isFocused) Modifier.border(
                    width = 20.dp,
                    color = focusBorderColor,
                    shape = RoundedCornerShape(26.dp)
                ) else Modifier
            ),
        contentAlignment = Alignment.Center
    ) {
        Button(
            onClick = onClick,
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp),

            enabled = isEnabled,
            shape = RoundedCornerShape(24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = backgroundColor,
                contentColor = ButtonContentColor,
                disabledContainerColor = ButtonDisabled,
                disabledContentColor = ButtonContentColor
            ),
            interactionSource = interactionSource,
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 4.dp,
                pressedElevation = 2.dp,
                hoveredElevation = 6.dp,
                disabledElevation = 0.dp
            ),
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                if (iconPosition == BtnIconPosition.Left) {
                    Image(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
                Text(
                    text = text,
                    fontFamily = manropeBold,
                    color = ButtonContentColor,
                    style = MaterialTheme.typography.bodyLarge,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.weight(1f)
                )
                if (iconPosition == BtnIconPosition.Right) {
                    Image(
                        painter = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                            .graphicsLayer { scaleX = -1f }
                    )
                }
            }
        }
    }
}

enum class BtnIconPosition {
    Left, Right, None
}


@Preview(showBackground = true)
@Composable
fun BotonPreview() {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Boton(
            text = "With Icon Left",
            onClick = {},
            isEnabled = true,
            iconPosition = BtnIconPosition.Left
        )

        Boton(
            text = "With Icon Right",
            onClick = {},
            isEnabled = true,
            iconPosition = BtnIconPosition.Right
        )

        Boton(
            text = "No Icon",
            onClick = {},
            isEnabled = false,
            iconPosition = BtnIconPosition.None
        )

        Boton(
            text = "Button with Focus",
            onClick = {},
            isEnabled = true,
            iconPosition = BtnIconPosition.Left,
            modifier = Modifier.focusRequester(focusRequester)
        )
    }
}