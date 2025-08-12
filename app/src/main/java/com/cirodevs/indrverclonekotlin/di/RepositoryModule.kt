package com.cirodevs.indrverclonekotlin.di

import com.cirodevs.indrverclonekotlin.data.local.datastore.LocalDataStore
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.AuthService
import com.cirodevs.indrverclonekotlin.data.remote.dataSource.remote.services.UserService
import com.cirodevs.indrverclonekotlin.data.remote.repository.AuthRepositoryImpl
import com.cirodevs.indrverclonekotlin.data.remote.repository.UserRepositoryImpl
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import com.cirodevs.indrverclonekotlin.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {


    @Provides
    fun provideAuthRepository(authService: AuthService, localDataStore: LocalDataStore): AuthRepository =
        AuthRepositoryImpl(authService, localDataStore)

    @Provides
    fun provideUserRepository(userService: UserService): UserRepository = UserRepositoryImpl(userService)



}