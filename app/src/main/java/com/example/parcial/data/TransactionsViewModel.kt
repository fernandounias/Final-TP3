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

class TransactionsViewModel : ViewModel() {

    private val _transactions = MutableLiveData<List<Transaction>>()
    val transactions : LiveData<List<Transaction>> = _transactions

    private val firebaseFireStore = FirebaseFirestore.getInstance()
    val userDocumentRef = firebaseFireStore.collection("wallet").document("LkiSh1GJTWnkb42dZKbr")

    init {
        viewModelScope.launch {
            fetchTransactions()
        }
    }

    private suspend fun fetchTransactions() {
        try {
            val documentSnapshot = userDocumentRef.collection("transactions")
                .document("xhR2NAxvFRnVUejmM26W")
                .get()
                .await()
        Log.d("TransactionsList", "AllTransactio tdocumentSnapshot ch: $documentSnapshot")
            if (documentSnapshot.exists()) {
                val creditCardTransactions = documentSnapshot.get("credit_card_transactions") as? List<Map<String, Any>>

                if (creditCardTransactions != null) {
                    val transactionsList = creditCardTransactions.map { transactionData ->
                        Transaction(
                            amount = transactionData["amount"] as? Double ?: 0.0,
                            currency = transactionData["currency"] as? String ?: "",
                            date = transactionData["date"] as? String ?: "",
                            description = transactionData["description"] as? String ?: "",
                            transactionId = transactionData["transaction_id"] as? String ?: "",
                            type = transactionData["type"] as? String ?: "",
                            userId = transactionData["user_id"] as? Int ?: 0
                        )
                    }
                    _transactions.value = transactionsList
                    Log.d("TransactionsList", "AllTransactio transacoines en el if: ${_transactions}")
                } else {
                    Log.d("TransactionsList", "No se encontraron transacciones en credit_card_transactions.")
                }
            } else {
                Log.d("TransactionsList", "El documento no existe.")
            }
        } catch (e: FirebaseFirestoreException) {
            Log.e("TransactionsList", "Error al obtener documentos:", e)
        } catch (e: Exception) {
            Log.e("TransactionsList", "Error general al obtener documentos:", e)
        }
    }}