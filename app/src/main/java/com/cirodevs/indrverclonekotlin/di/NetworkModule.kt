package com.cirodevs.indrverclonekotlin.di

import com.cirodevs.indrverclonekotlin.core.Config
import com.cirodevs.indrverclonekotlin.data.local.datastore.LocalDataStore
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.AuthService
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.UserService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(dataStore: LocalDataStore) = OkHttpClient.Builder().addInterceptor {
        val token = runBlocking {
            dataStore.getData().first().token
        }
        val newRequest = it.request().newBuilder()
            .addHeader("Authorization", token ?: "")
            .build()
        it.proceed(newRequest)
    }.build()

    @Provides
    @Singleton
    // ESTO SE COMUNICARA DIRECTO CON EL BACKEND COMO EL POSTMAN
    fun provideRetrofit( okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Config.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): AuthService {
        return retrofit.create(AuthService::class.java)

    }

    @Provides
    @Singleton
    fun provideUserService(retrofit: Retrofit): UserService {
        return retrofit.create(UserService::class.java)

    }
}