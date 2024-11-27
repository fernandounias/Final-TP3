package com.example.parcial.shared.infraestructure.Auth

import android.util.Log
import com.example.parcial.shared.infraestructure.RetrofitModule
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
//class AuthRepository(private val authServices: AuthServices = RetrofitModule.authServices) {
class AuthRepository @Inject constructor(private val authServices: AuthServices) {
    //use of constructor injection to provide the services repositories

    suspend fun login(credentials: LoginRequest): Result<LoginResponse>{
        return try {
            val response = authServices.login(credentials)
//            Log.d("AuthRepository", "credentials: $credentials")
//            Log.d("response.body", "$response.body")
            if (response.isSuccessful) {
                Result.success(response.body()!!)
                //!!  treats the nullable type as if it’s a non-nullable type
            } else {
                Result.failure(Exception("Login failed: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }


}