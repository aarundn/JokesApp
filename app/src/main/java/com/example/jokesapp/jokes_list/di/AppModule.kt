package com.example.jokesapp.jokes_list.di

import com.example.jokesapp.jokes_list.data.JokesRepositoryImpl
import com.example.jokesapp.jokes_list.domain.repos.JokesRepository
import com.example.jokesapp.jokes_list.domain.repos.JokesSourceIdentifier
import com.example.jokesapp.jokes_list.domain.usecase.GetJokesUseCase
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
        return JokesRepositoryImpl(JokesSourceIdentifier(id = "id", "Default"))
    }

    @Provides
    @Singleton
    fun provideJokesUseCase(jokesRepository: JokesRepository): GetJokesUseCase {
        return GetJokesUseCase(jokesRepository)
    }
}