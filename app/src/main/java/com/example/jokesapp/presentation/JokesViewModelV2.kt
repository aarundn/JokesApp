package com.example.jokesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.data.AlgerianJokesSourceID
import com.example.jokesapp.data.EgyptianJokesSourceID
import com.example.jokesapp.domain.usecase.GetJokesUseCaseV2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModelV2 @Inject constructor(
    private val getJokesUseCase: GetJokesUseCaseV2
) : ViewModel() {

    private val _joke = MutableStateFlow<JokesState>(JokesState.Loading)
    val joke: StateFlow<JokesState> = _joke.asStateFlow()

    private val _selectedSourceId = MutableStateFlow<String?>(null)
    val selectedSourceId: StateFlow<String?> = _selectedSourceId.asStateFlow()


    init {
        //DEFAULT SOURCE ID
        _selectedSourceId.value = AlgerianJokesSourceID
        getJokes()
    }

    private fun selectSource(selectSource: String) {
        _selectedSourceId.value = selectSource
        getJokes()
    }

    private fun getJokes() {
        val selectSource = _selectedSourceId.value ?: return
        viewModelScope.launch {
            _joke.value = JokesState.Loading
            delay(1000)
            try {
                getJokesUseCase(selectSource).collect {
                    _joke.value = JokesState.Success(it)
                }
            } catch (e: Exception) {
                _joke.value = JokesState.Error(e.localizedMessage ?: "")
            }
        }
    }

    fun onAction(action: JokesScreenAction) {
        when (action) {
            is JokesScreenAction.OnScreenClick -> {
                if (selectedSourceId.value == EgyptianJokesSourceID)
                    selectSource(AlgerianJokesSourceID)
                else
                    selectSource(EgyptianJokesSourceID)
            }
        }
    }
}