package com.example.parcial.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.parcial.R
import com.example.parcial.model.model.transaction.Transaction
import com.example.parcial.ui.theme.DarkPurple


@Composable
fun TransactionsSection(transactions: State<List<Transaction>?>) {


    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .sizeIn(minWidth = 360.dp, minHeight = 36.dp)
                    .background(DarkPurple)
                    .padding(horizontal = 8.dp, vertical = 10.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.account_movements),
                    style = TextStyle(
                        fontFamily = FontFamily(
                            Font(R.font.manrope_bold)
                        ),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        lineHeight = 19.6.sp,
                        textAlign = TextAlign.Left
                    ),
                    color = Color.White
                )
            }
        LazyColumn {
            transactions.value?.let { transactionsList ->
                if (transactionsList.isEmpty()) {
                    item {
                        Text(
                            text = "No hay transacciones disponibles",
                            modifier = Modifier.padding(vertical = 16.dp),
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                } else {
                    items(
                        items = transactionsList,
                    ) { transaction ->
                        DetalleFila(
                            fecha = transaction.date,
                            descripcion = transaction.description,
                            monto = transaction.amount,
                            autorizacion = transaction.transactionId,
                            type = transaction.type,
                            modifier = Modifier. padding(horizontal = 8.dp, vertical = 0.dp)
                        )
                    }
                }
            } ?: item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }
        }

    }
}