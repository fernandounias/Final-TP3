package com.example.parcial.shared.infraestructure.Auth

import com.google.gson.annotations.SerializedName

class LoginDTO (
    @SerializedName("username")  val username: String,
    @SerializedName("password")  val password: String
){
    fun toLoginRequest() = LoginRequest(username, password)
}
