package com.example.parcial.model.model.user


data class User (
    val id: Int,
    val email: String,
    val username: String,
    val password: String,
    val name: Name,
)
data class Name(
    val firstName: String,
    val lastName: String
)
data class LoginResponse(
    val token: String
)