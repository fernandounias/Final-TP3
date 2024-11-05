package com.example.parcial.model.users

import com.example.parcial.model.users.User
interface IUser {
    suspend fun getUser(userId: Int): User?
    suspend fun addUser(username: String, password: String): User?
}