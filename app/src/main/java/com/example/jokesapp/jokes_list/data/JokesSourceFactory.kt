package com.example.jokesapp.jokes_list.data

import android.util.Log
import com.example.jokesapp.jokes_list.domain.repos.JokesRepository

private const val TAG = "JokesSourceFactory"
const val EgyptianJokesSourceID = "EgyptianJokesID"
const val AlgerianJokesSourceID = "AlgerianJokesSourceID"

object JokesSourceFactory {
    private val sources = mutableMapOf<String, JokesRepository>()

    fun addSource(source: JokesRepository) {
        sources[source.identifier.id] = source
        Log.d(TAG, "source: ${source.identifier.name} added")
    }

    fun getSource(sourceId: String) = sources[sourceId]

    fun getAllSourcesIdentifiers() = sources.values.map { it.identifier }
}