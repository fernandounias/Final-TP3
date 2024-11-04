package com.example.parcial.model.model.user

interface IUser {
    suspend fun getUser(userId: Int): User?
    suspend fun addUser(username: String, password: String): User?

}