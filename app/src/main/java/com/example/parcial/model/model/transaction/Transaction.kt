package com.example.parcial.model.model.transaction

data class Transaction (
    val transactionId: String,
    val amount: Number,
    val date: String,
    val description: String,
    val type: String,
    val currency: String,
    val userId: Int
)