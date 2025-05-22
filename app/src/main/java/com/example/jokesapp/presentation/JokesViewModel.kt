package com.example.jokesapp.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.jokesapp.domain.model.Jokes
import com.example.jokesapp.domain.usecase.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val getJokesUseCase: GetJokesUseCase
): ViewModel() {


    private var _jokes by mutableStateOf(emptyList<Jokes>())

    val jokes: List<Jokes>
        get() = _jokes


    init {
        getJokes()
    }

    private fun getJokes(){
        _jokes = getJokesUseCase.execute()
    }

}