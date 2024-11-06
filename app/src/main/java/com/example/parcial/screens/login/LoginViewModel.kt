package com.example.parcial.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.parcial.shared.infraestructure.Auth.AuthRepository
import com.example.parcial.shared.infraestructure.Auth.AuthServices
import com.example.parcial.shared.infraestructure.Auth.LoginDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

//class LoginViewModel(private val authServices: AuthServices) : ViewModel() {
class LoginViewModel(private val repository: AuthRepository) : ViewModel() {

    private val _loginResult = MutableStateFlow<String?>(null)

    val loginResult: StateFlow<String?> get() = _loginResult
        ///StateFlow is read only for encapsulation
        ///get() = _loginResult its a custom getter

    fun login(username: String, password: String) {
        viewModelScope.launch {

            val loginDTO = LoginDTO(username, password)
            val credentials = loginDTO.toLoginRequest()
                /// explicación de como funcióna en ingles para no traducir los terminos DTO & Separation of Concerns
                /// DTO = Data Transfer Object
                /// We use it to encapsulate username & password, with serialization properties
                /// also for separation of concerns = separate how data is stored from how is sent to the server
                /// now toLoginRequest() that can be modified if the server needs the data in another format
                /// toLoginRequest() can be changed by modifing the Data class LoginRequest

            try {
                val response = repository.login(credentials)
                if (response.isSuccess) {
                    _loginResult.value = "Login successful: ${response.getOrNull()?.token}"
                    ///
                } else {
                    _loginResult.value = "Login failed"
                }
            } catch (e: Exception) {
                _loginResult.value = "Login error: ${e.message}"
            }
        }
    }
}