package com.example.parcial.screens.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial.data.TransactionsCvuViewModel
import com.example.parcial.model.model.transaction.Transaction
import kotlinx.coroutines.launch

class AccountViewModel(
    private val transactionsViewModel: TransactionsCvuViewModel = TransactionsCvuViewModel()
) : ViewModel() {

    val transactions: LiveData<List<Transaction>> = transactionsViewModel.transactions
    val cvu: LiveData<String> = transactionsViewModel.cvu

    init {
        viewModelScope.launch{
        }
    }
}