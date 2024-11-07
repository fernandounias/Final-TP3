package com.example.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.parcial.R
import com.example.parcial.ui.theme.BackgroundScreens
import com.example.parcial.ui.theme.DarkPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogSubeConfirmacion(
    onDismiss: () -> Unit,
    title: String,
    image: Painter,
    msg: String
) {
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    Dialog(onDismissRequest = onDismiss
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = screenHeight * 0.70f)
                .background(BackgroundScreens)
        ) {
            Column(
                modifier = Modifier
                    .background(BackgroundScreens)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar(
                    title = { Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleLarge.copy(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.manrope_bold)),
                                color = DarkPurple
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                    },
                    actions = {
                        IconButton(onClick = onDismiss) {
                            Icon(Icons.Default.Close, contentDescription = "Cerrar")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White,
                        titleContentColor = DarkPurple,
                        navigationIconContentColor = DarkPurple
                    )
                )
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = Color.Gray.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(150.dp))
                Image(
                    painter = image,
                    contentDescription = "Icono de confirmación",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = msg,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(Font(R.font.manrope_bold)),
                        color = DarkPurple
                    ),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 18.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Boton(
                        text = "Finalizar",
                        onClick = onDismiss,
                        isEnabled = true,
                        iconPosition = BtnIconPosition.None
                    )
                }
            }
        }
    }
}
