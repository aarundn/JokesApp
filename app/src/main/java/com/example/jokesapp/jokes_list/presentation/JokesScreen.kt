package com.example.jokesapp.jokes_list.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.jokesapp.jokes_list.domain.model.Joke

@Composable
fun JokesScreen(
    modifier: Modifier = Modifier,
    state: JokesStateV1,
    onAction: (JokesScreenAction) -> Unit,
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { onAction(JokesScreenAction.OnScreenClick) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when {
            state.isLoading -> CircularProgressIndicator()
            state.errorMessage != null -> onAction(JokesScreenAction.ShowSnackBar(state.errorMessage))
            else -> JokesContent(
                state.jokes,
                onAction = onAction
            )
        }
    }
}

@Composable
fun JokesContent(
    jokes: List<Joke>,
    onAction: (JokesScreenAction) -> Unit
) {
    LazyColumn {
        items(jokes.size, key = { it }) {
            Text(
                text = jokes[it].content,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier.clickable(onClick = {
                    onAction(
                        JokesScreenAction.OnJokeClicked(
                            jokes[it].id.toString()
                        )
                    )
                })
            )
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}