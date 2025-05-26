package com.example.jokesapp.jokes_list.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jokesapp.jokes_list.data.AlgerianJokesSourceID
import com.example.jokesapp.jokes_list.data.EgyptianJokesSourceID
import com.example.jokesapp.jokes_list.domain.usecase.GetJokesUseCaseV2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JokesViewModelV2 @Inject constructor(
    private val getJokesUseCase: GetJokesUseCaseV2
) : ViewModel() {

    private val _sideEffect = MutableSharedFlow< JokeListSideEffect>()
    val sideEffects = _sideEffect.asSharedFlow()

    private val _jokeState = MutableStateFlow(JokesStateV1())
    val jokeStates = _jokeState.asStateFlow()


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
            _jokeState.update {
                it.copy(isLoading = true)
            }
            _joke.value = JokesState.Loading
            delay(1000)
            try {
                getJokesUseCase(selectSource).collect {
                    _jokeState.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            jokes = it,
                        )
                    }
                    _joke.value = JokesState.Success(it)
                }
            } catch (e: Exception) {
                _jokeState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        errorMessage = e.localizedMessage ?: "Unknown Error"
                    )
                }
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
            is JokesScreenAction.OnJokeClicked -> jokeClicked(action.jokeId)
            is JokesScreenAction.ShowSnackBar -> showSnackBar(action.message)
        }
    }

    fun jokeClicked(jokeId: String){
        viewModelScope.launch {
            _sideEffect.emit(JokeListSideEffect.NavigateToDetails(jokeId))
        }
    }
    fun showSnackBar(message: String) {
        viewModelScope.launch {
            _sideEffect.emit(JokeListSideEffect.ShowSnackBar(message))
        }
    }
}