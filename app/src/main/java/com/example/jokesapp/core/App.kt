package com.example.jokesapp.core

import android.app.Application
import com.example.jokesapp.jokes_list.data.AlgerianJokesRepositoryImpl
import com.example.jokesapp.jokes_list.data.AlgerianJokesSourceID
import com.example.jokesapp.jokes_list.data.EgyptianJokesRepositoryImpl
import com.example.jokesapp.jokes_list.data.EgyptianJokesSourceID
import com.example.jokesapp.jokes_list.data.JokesSourceFactory
import com.example.jokesapp.jokes_list.domain.repos.JokesSourceIdentifier
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