package com.example.parcial.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial.shared.infraestructure.Auth.AuthRepository
import com.example.parcial.shared.infraestructure.Auth.LoginDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginResult = MutableStateFlow<String?>(null)
    val loginResult: StateFlow<String?> get() = _loginResult

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val loginDTO = LoginDTO(username, password)
            val credentials = loginDTO.toLoginRequest()
            try {
                val response = repository.login(credentials)
                _loginResult.value = if (response.isSuccess) {
                    "Login successful: ${response.getOrNull()?.token}"
                } else {
                    "Login failed: ${response.exceptionOrNull()?.message ?: "Unknown error"}"
                }
            } catch (e: Exception) {
                _loginResult.value = "Login error: ${e.message}"
            }
        }
    }
}