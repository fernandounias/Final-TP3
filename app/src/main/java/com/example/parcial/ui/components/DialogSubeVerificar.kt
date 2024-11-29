package com.example.parcial.ui.components

import VisualizadorSaldo
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.parcial.ui.LocalColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogSubeVerificar(
    title: String = "Cargar Sube",
    cardNumber: String = "6061 3580 2384 9041",
    amount: Number = 200,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {

    Dialog(
        onDismissRequest = onDismiss,
        //
        properties = DialogProperties(usePlatformDefaultWidth = false)
    ) {
        Surface(
            color = LocalColors.current.background,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .background( color = LocalColors.current.background)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = title,
                                style = MaterialTheme.typography.titleLarge.copy(
                                    fontSize = 18.sp,
                                    fontFamily = FontFamily(Font(R.font.manrope_bold)),
                                    color = LocalColors.current.textTitles
                                ),
                                textAlign = TextAlign.Center
                            )
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = onDismiss) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = "Atrás",
                                tint = LocalColors.current.textTitles
                            )
                        }
                    },
                    actions = {
                        IconButton(onClick = onDismiss) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = "Cerrar",
                                tint = LocalColors.current.textTitles
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = LocalColors.current.background,
                        titleContentColor = LocalColors.current.textTitles,
                        navigationIconContentColor = LocalColors.current.textTitles
                    )
                )
                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(1.dp),
                    color = Color.Gray.copy(alpha = 0.5f)
                )
                Spacer(modifier = Modifier.height(30.dp))
                Text(
                    text = "Verificá que la información sea correcta:",
                    style = (
                            MaterialTheme.typography.titleLarge.copy(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(
                                    Font(R.font.manrope_extrabold)
                                ),
                                color = LocalColors.current.textTitles
                            )),
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(horizontal = 20.dp),
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = Modifier.height(40.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.99f),
                    verticalArrangement = Arrangement.SpaceAround
                ){
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .padding(vertical = 20.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors =  CardDefaults.cardColors(containerColor = LocalColors.current.inputBackground),
                        elevation = CardDefaults.cardElevation(14.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.sube_logo),
                                contentDescription = "Logo SUBE",
                                modifier = Modifier.size(90.dp)
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            HorizontalDivider()
                            Spacer(modifier = Modifier.height(10.dp))
                            Row(){
                                Text(
                                    text = "Tarjeta No: ",
                                    style = (
                                            MaterialTheme.typography.titleLarge.copy(
                                                fontSize = 14.sp,
                                                fontFamily = FontFamily(
                                                    Font(R.font.manrope_bold)
                                                ),
                                                color = LocalColors.current.inputLabel
                                            ))
                                )
                                Text(
                                    text = cardNumber,
                                    style = (
                                            MaterialTheme.typography.titleLarge.copy(
                                                fontSize = 14.sp,
                                                fontFamily = FontFamily(
                                                    Font(R.font.manrope_bold)
                                                ),
                                                color = LocalColors.current.textTitles
                                            ))

                                )
                            }
                            Spacer(modifier = Modifier.height(10.dp))
                            HorizontalDivider()
                            VisualizadorSaldo(
                                texto = "",
                                saldo = amount,
                                textoSize = 28,
                                saldoSize = 12
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(50.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 14.dp),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Boton(
                            text = "Continuar",
                            onClick = onConfirm,
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
fun DialogSubeVerificarPreview() {
    DialogSubeVerificar(
        title = "Cargar Sube",
        cardNumber = "6061 3580 2384 9041",
        amount = 200,
        onDismiss = {},
        onConfirm = {}
    )
}
