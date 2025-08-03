package com.cirodevs.indrverclonekotlin.di

import com.cirodevs.indrverclonekotlin.domain.repository.AuthRepository
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.AuthUseCases
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.LoginUseCase
import com.cirodevs.indrverclonekotlin.domain.useCases.auth.RegisterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideAuthUseCases(authRepository: AuthRepository) = AuthUseCases (
            login = LoginUseCase(authRepository),
            register = RegisterUseCase(authRepository)
    )


}