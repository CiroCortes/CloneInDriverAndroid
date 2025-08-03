package com.cirodevs.indrverclonekotlin.di

import com.cirodevs.indrverclonekotlin.data.dataSource.remote.services.AuthService
import com.cirodevs.indrverclonekotlin.data.repository.AuthRepositoryImpl
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideAuthRepository(authService: AuthService): AuthRepository =
        AuthRepositoryImpl(authService)


}