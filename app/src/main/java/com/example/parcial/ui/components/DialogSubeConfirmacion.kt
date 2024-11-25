package com.example.parcial.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.parcial.R
import com.example.parcial.ui.theme.DarkPurple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogSubeConfirmacion(
    onDismiss: () -> Unit,
    title: String,
    image: Painter,
    msg: String
) {

    Dialog(
        onDismissRequest = onDismiss,
        //
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            color = Color.White,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
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
                Spacer(modifier = Modifier.height(50.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.93f),
                    verticalArrangement = Arrangement.SpaceBetween
                ){
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .weight(0.6f),
                        contentAlignment = Alignment.Center
                    ){
                        Column(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
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
                        }
                    }

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
}
@Preview
@Composable
fun DialogSubeConfirmacionPreview() {
    DialogSubeConfirmacion(
        title = "Cargar Sube",
        onDismiss = { false },
        image = painterResource(id = R.drawable.ok_),
        msg = "Tu operacion se ha realizado con éxito"
    )
}