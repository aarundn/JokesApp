package com.example.jokesapp.core

import android.app.Application
import com.example.jokesapp.data.AlgerianJokesRepositoryImpl
import com.example.jokesapp.data.AlgerianJokesSourceID
import com.example.jokesapp.data.EgyptianJokesRepositoryImpl
import com.example.jokesapp.data.EgyptianJokesSourceID
import com.example.jokesapp.data.JokesSourceFactory
import com.example.jokesapp.domain.repos.JokesSourceIdentifier
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupJokesSources()
    }
}

fun setupJokesSources() {
    JokesSourceFactory.addSource(
        EgyptianJokesRepositoryImpl(
            JokesSourceIdentifier(
                id = EgyptianJokesSourceID,
                name = "Egyptian"
            )
        )
    )
    JokesSourceFactory.addSource(
        AlgerianJokesRepositoryImpl(
            JokesSourceIdentifier(
                id = AlgerianJokesSourceID,
                name = "Algerian"
            )
        )
    )
}