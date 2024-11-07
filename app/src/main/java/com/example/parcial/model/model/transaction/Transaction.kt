package com.example.parcial.model.model.transaction

data class Transaction(
    val amount: Double,
    val currency: String,
    val date: String,
    val description: String,
    val transactionId: String,
    val type: String,
    val userId: Int
)