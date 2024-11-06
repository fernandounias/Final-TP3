package com.example.parcial.shared.infraestructure.users

import UserResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface UserServices {

    @GET("users/{userId}")
    suspend fun getUser(@Path("userId") userId: Int): Response<UserResponse>

    @POST("users")
    suspend fun addUser(): Response<UserResponse>

}