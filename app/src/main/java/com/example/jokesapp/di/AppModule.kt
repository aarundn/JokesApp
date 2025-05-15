package com.example.jokesapp.di

import com.example.jokesapp.data.JokesRepositoryImpl
import com.example.jokesapp.domain.repos.JokesRepository
import com.example.jokesapp.domain.usecase.GetJokesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideJokesRepository(): JokesRepository {
        return JokesRepositoryImpl()
    }

    @Provides
    @Singleton
    fun provideJokesUseCase(jokesRepository: JokesRepository): GetJokesUseCase {
        return GetJokesUseCase(jokesRepository)
    }
}