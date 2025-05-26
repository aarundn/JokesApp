package com.example.jokesapp.jokes_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.jokes_list.domain.usecase.GetJokesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModel @Inject constructor(
    private val getJokesUseCase: GetJokesUseCase
) : ViewModel() {

    private val _joke = MutableStateFlow<JokesState>(JokesState.Loading)
    val joke: StateFlow<JokesState> = _joke.asStateFlow()


    init {
        getJokes()
    }

    private fun getJokes() {
        viewModelScope.launch {
            delay(1000)
            try {
                getJokesUseCase().collect {
                    _joke.value = JokesState.Success(it)
                }
            } catch (e: Exception) {
                _joke.value = JokesState.Error(e.localizedMessage ?: "")
            }
        }
    }
}