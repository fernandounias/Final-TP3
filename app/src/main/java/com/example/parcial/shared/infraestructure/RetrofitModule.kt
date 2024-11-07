package com.example.parcial.shared.infraestructure

import com.example.parcial.shared.infraestructure.Auth.AuthServices
import com.example.parcial.shared.infraestructure.users.UserServices
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitModule {

    private const val BASE_URL = "https://fakestoreapi.com/"
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val authServices: AuthServices by lazy {
        retrofit.create(AuthServices::class.java)
    }
    val userServices: UserServices by lazy {
        retrofit.create(UserServices::class.java)
    }
}