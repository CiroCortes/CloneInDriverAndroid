package com.cirodevs.indrverclonekotlin.di

import com.cirodevs.indrverclonekotlin.data.dataSource.local.datastore.LocalDataStore
import com.cirodevs.indrverclonekotlin.data.dataSource.location.LocationDataSource
import com.cirodevs.indrverclonekotlin.data.dataSource.remote.services.AuthService
import com.cirodevs.indrverclonekotlin.data.dataSource.remote.services.UserService
import com.cirodevs.indrverclonekotlin.data.repository.AuthRepositoryImpl
import com.cirodevs.indrverclonekotlin.data.repository.LocationRepositoryImpl
import com.cirodevs.indrverclonekotlin.data.repository.UserRepositoryImpl
import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import com.cirodevs.indrverclonekotlin.domain.repository.LocationRepository
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

    @Provides
    fun provideLocationRepository(locationDataSource: LocationDataSource): LocationRepository =
        LocationRepositoryImpl(locationDataSource)





}