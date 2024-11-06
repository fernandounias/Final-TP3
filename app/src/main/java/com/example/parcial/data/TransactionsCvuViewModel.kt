package com.example.parcial.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial.model.model.transaction.Transaction
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class TransactionsCvuViewModel : ViewModel() {

    private val _transactions = MutableLiveData<List<Transaction>>()
    private val _cvu = MutableLiveData<String>()
    val transactions: LiveData<List<Transaction>> = _transactions
    val cvu: LiveData<String> = _cvu

    private val firebaseFireStore = FirebaseFirestore.getInstance()
    private val userDocumentRef =
        firebaseFireStore.collection("wallet").document("LkISh1GJTWnkb42dZKbr")

    init {
        viewModelScope.launch {
            fetchCvu()
            fetchTransactions()
        }
    }

    private suspend fun fetchTransactions() {
        try {
            val documentSnapshot = userDocumentRef.collection("transactions")
                .document("xhR2NAxvFRnVUejmM26W")
                .get()
                .await()
            Log.d("TransactionsList", "Document Snapshot: $documentSnapshot")

            if (documentSnapshot.exists()) {
                val transactionsData = documentSnapshot.get("transactions") as? Map<String, Any>
                val bankAccountTransactions =
                    transactionsData?.get("bank_account_transactions") as? List<Map<String, Any>>
                val creditCardTransactions =
                    transactionsData?.get("credit_card_transactions") as? List<Map<String, Any>>


                val transactionsList = mutableListOf<Transaction>()

                bankAccountTransactions?.let {
                    transactionsList.addAll(it.map { transactionData ->
                        mapToTransaction(transactionData)
                    })
                }
                creditCardTransactions?.let {
                    transactionsList.addAll(it.map { transactionData ->
                        mapToTransaction(transactionData)
                    })
                }
                transactionsList.sortByDescending { transaction ->
                    parseDate(transaction.date)
                }

                _transactions.value = transactionsList
                Log.d(
                    "TransactionsList",
                    "Fetched Bank Account Transactions: ${_transactions.value}"
                )
            } else {
                Log.d("TransactionsList", "El documento no existe en la ruta especificada.")
            }
        } catch (e: FirebaseFirestoreException) {
            Log.e("TransactionsList", "Error al obtener documentos:", e)
        } catch (e: Exception) {
            Log.e("TransactionsList", "Error general al obtener documentos:", e)
        }
    }

    private suspend fun fetchCvu() {
        try {
            val documentSnapshot = userDocumentRef.collection("bank_account")
                .document("Nyonb8R1oO8bAViJTTi1")
                .get()
                .await()
            Log.d("ACAAAAAAAAAAAAAAAA bank account data -> ", "Document Snapshot: $documentSnapshot")
            _cvu.value = documentSnapshot.get("cvu") as? String ?: ""
            Log.d("ACAAAAAAAAAAAAAAAA bank account data -> ","cvu: ${_cvu.value}")
        } catch (e: FirebaseFirestoreException) {
            Log.e("TransactionsList", "Error al obtener documentos:", e)
        } catch (e: Exception) {
            Log.e("TransactionsList", "Error general al obtener documentos:", e)
        }
    }

    private fun mapToTransaction(transactionData: Map<String, Any>): Transaction {
        val amount = when (val amountValue = transactionData["amount"]) {
            is Long -> amountValue.toDouble()
            is Int -> amountValue.toDouble()
            is Double -> amountValue
            is Number -> amountValue.toDouble()
            else -> 0.0
        }

        return Transaction(
            amount = amount,
            currency = transactionData["currency"] as? String ?: "",
            date = transactionData["date"] as? String ?: "",
            description = transactionData["description"] as? String ?: "",
            transactionId = transactionData["transaction_id"] as? String ?: "",
            type = transactionData["type"] as? String ?: "",
            userId = transactionData["user_id"] as? Int ?: 0
        )
    }

    private fun parseDate(dateString: String): Date? {
        return try {
            val format = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
            format.parse(dateString)
        } catch (e: ParseException) {
            Log.e("TransactionsList", "Error al parsear la fecha: $dateString", e)
            null
        }
    }

}