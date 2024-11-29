package com.example.parcial.shared.infraestructure

import com.example.parcial.shared.infraestructure.Auth.AuthServices
import com.example.parcial.shared.infraestructure.users.UserServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
//import jakarta.inject.Singleton
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://fakestoreapi.com/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideAuthServices(retrofit: Retrofit): AuthServices {
        return retrofit.create(AuthServices::class.java)
    }

    @Provides
    @Singleton
    fun provideUserServices(retrofit: Retrofit): UserServices {
        return retrofit.create(UserServices::class.java)
    }

    //replaces RetrofitModule object and implemets its function with hilt
}