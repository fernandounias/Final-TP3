package com.example.parcial.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.parcial.shared.infraestructure.Auth.AuthRepository
import com.example.parcial.shared.infraestructure.Auth.AuthServices

//class LoginViewModelFactory(private val repository: AuthRepository) : ViewModelProvider.Factory {
class LoginViewModelFactory(private val authServices: AuthServices) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {

            val repository = AuthRepository(authServices)
            @Suppress("UNCHECKED_CAST")
            return LoginViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}