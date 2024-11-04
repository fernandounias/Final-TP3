package com.example.parcial.screens.account

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.parcial.MainNavActions
import com.example.parcial.data.TransactionsViewModel
import com.example.parcial.shared.BottomNavBar
import com.example.parcial.ui.theme.BackgroundScreens
import com.google.firebase.vertexai.type.content

@Preview
@Composable
fun AccountScreen() {
    //this is for testing
    val transactionsViewModel: TransactionsViewModel = viewModel()
Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center
) {

        Text(
            text = "Account SCREEsssN!",
            modifier = Modifier.background(Color.Cyan)
        )
        Spacer(modifier = Modifier.size(10.dp))
        TransactionsList(transactionsViewModel)
    }

}


@Composable
fun TransactionsList(transactionsViewModel: TransactionsViewModel) {
    val allTransactions = transactionsViewModel.transactions.observeAsState()

    allTransactions.value?.let { transactions ->
        LazyColumn {
            items(transactions) { transaction ->
                Text(
                    text = transaction.description,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Yellow),
                    fontSize = 20.sp
                )
                Spacer(modifier = Modifier.size(10.dp))
            }
        }
    } ?: run {
        Text("Loading transactions...")
    }
}