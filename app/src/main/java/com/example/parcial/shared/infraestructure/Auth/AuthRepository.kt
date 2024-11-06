package com.example.parcial.shared.infraestructure.Auth

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AuthRepository(private val api: AuthServices) {

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()

    val authServices = retrofit.create(AuthServices::class.java)

//    suspend fun login(username: String, password: String): Result<LoginResponse>{
    suspend fun login(credentials: LoginRequest): Result<LoginResponse>{
        return try {
//            val response = api.login(LoginRequest(username, password))
            val response = api.login(credentials)
            if (response.isSuccessful) {
                Result.success(response.body()!!)
                    ///!! is a not-null assertion operator => the value is not null & if it is null throw a nullPointerException
            } else {
                Result.failure(Exception("Login failed: ${response.errorBody()?.string()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}