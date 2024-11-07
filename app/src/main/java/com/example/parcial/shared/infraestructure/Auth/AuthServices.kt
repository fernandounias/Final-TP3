package com.example.parcial.shared.infraestructure.Auth

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthServices {
    @POST("auth/login")
    suspend fun login(
        @Body credentials: LoginRequest
    ): Response<LoginResponse>

}

