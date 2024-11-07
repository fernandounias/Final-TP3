package com.example.parcial.shared.infraestructure.Auth

import android.util.Log
import com.example.parcial.shared.infraestructure.RetrofitModule

class AuthRepository(private val authServices: AuthServices = RetrofitModule.authServices) {

    suspend fun login(credentials: LoginRequest): Result<LoginResponse>{
        return try {
            val response = authServices.login(credentials)
            Log.d("AuthRepository", "credentials: $credentials")
            Log.d("response.body", "$response.body")
            if (response.isSuccessful) {
                Result.success(response.body()!!)
            } else {
                Result.failure(Exception("Login failed: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}