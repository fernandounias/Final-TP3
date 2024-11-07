package com.example.parcial.shared.infraestructure

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.parcial.shared.infraestructure.Auth.AuthRepository
import com.example.parcial.shared.infraestructure.Auth.AuthServices

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

}