package com.example.parcial.shared.infraestructure.Auth

data class LoginRequest(val username: String, val password: String)
data class LoginResponse(val token: String)