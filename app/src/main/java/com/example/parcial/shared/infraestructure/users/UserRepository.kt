package com.example.parcial.shared.infraestructure.users

import com.example.parcial.shared.infraestructure.RetrofitModule
import UserResponse
import jakarta.inject.Inject
import jakarta.inject.Singleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

@Singleton
//class UserRepository(private val userServices: UserServices = RetrofitModule.userServices) {
class UserRepository @Inject constructor(private val userServices: UserServices) {
    //use of constructor injection to provide the services repositories

    suspend fun getUser(userId: Int): Result<UserResponse> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<UserResponse> = userServices.getUser(userId)
                if (response.isSuccessful) {
                    response.body()?.let {
                        Result.success(it)
                    } ?: Result.failure(Exception("Empty body"))
                } else {
                    Result.failure(Exception("Error: ${response.message()}"))
                }
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}
