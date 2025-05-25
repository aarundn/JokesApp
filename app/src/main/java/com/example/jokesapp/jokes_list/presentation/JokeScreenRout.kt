package com.example.jokesapp.jokes_list.presentation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.jokesapp.core.AppCoordinator

@Composable
fun JokesScreenRout(
    modifier: Modifier = Modifier,
    coordinator: AppCoordinator,
    showSnackBar: SnackbarHostState,
    viewModel: JokesViewModelV2 = hiltViewModel<JokesViewModelV2>()
    ) {

    val jokesState = viewModel.jokeStates.collectAsStateWithLifecycle()
    LaunchedEffect(Unit) {
        viewModel.sideEffects.collect { event ->
            when (event) {
                is JokeListSideEffect.ShowSnackBar -> {
                    showSnackBar.showSnackbar(event.message)
                }
                is JokeListSideEffect.NavigateToDetails -> {
                    coordinator.navigateToJokeDetails(event.jokeId)
                }
            }
        }
    }

    JokesScreen(
        modifier = modifier,
        state = jokesState.value,
        onAction = viewModel::onAction,
    )
}