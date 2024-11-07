package com.example.parcial.shared.infraestructure.Auth

import android.util.Log
import com.example.parcial.shared.infraestructure.RetrofitModule
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//class AuthRepository(private val api: AuthServices) {
class AuthRepository(private val authServices: AuthServices = RetrofitModule.authServices) {

         /// retrofit way
//        suspend fun login(credentials: LoginRequest): Response<LoginResponse> {
//            return authServices.login(credentials)
//        }

        ///kotlin way (aligns more closely with Kotlin’s design philosophy)
    suspend fun login(credentials: LoginRequest): Result<LoginResponse>{
        return try {
//            val response = api.login(LoginRequest(username, password))
            val response = authServices.login(credentials)
            Log.d("AuthRepository", "credentials: $credentials")
            Log.d("response.body", "$response.body")
            if (response.isSuccessful) {
                Result.success(response.body()!!)
                    ///!! is a not-null assertion operator => the value is not null & if it is null throw a nullPointerException
            } else {
                Result.failure(Exception("Login failed: ${response.errorBody()?.string()}"))
//                Result.failure(Exception("Login failed with code: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}