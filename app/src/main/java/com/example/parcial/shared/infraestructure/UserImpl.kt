package com.example.parcial.shared.infraestructure.users

import android.util.Log
import com.example.parcial.model.model.user.IUser
import com.example.parcial.model.model.user.Name
import com.example.parcial.model.model.user.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserImpl: IUser {
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://fakestoreapi.com/")
        .build()

    private val api = retrofit.create(UsersApi::class.java)
    override suspend fun getUser(userId: Int): User? {
        val response = api.getUser(userId)
Log.d("UserImpl", "getUser: $response")
        return if (response.isSuccessful) {
            val result = response.body()?.toModel()
            if (result != null) {
                result
            } else {
                User(0, "Not Found", "Not Found", "Not Found", Name("Not Found", "Not Found"),)
            }
        } else {
            null
        }
    }

    override suspend fun addUser(username: String, password: String): User? {
        TODO("Not yet implemented")
       // val response = api.addUser()
    }

}
