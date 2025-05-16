package com.example.jokesapp.presentation

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jokesapp.domain.model.Joke

@Composable
fun JokesScreen(
    modifier: Modifier = Modifier,
    viewModel: JokesViewModelV2 = hiltViewModel()
) {
    val jokesState by viewModel.joke.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .clickable { viewModel.onAction(JokesScreenAction.OnScreenClick) },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (jokesState) {
            is JokesState.Success -> JokesContent((jokesState as JokesState.Success).jokes)
            is JokesState.Loading -> CircularProgressIndicator()
            is JokesState.Error -> Text(text = (jokesState as JokesState.Error).message)
        }
    }
}

@Composable
fun JokesContent(jokes: List<Joke>) {
    LazyColumn {
        items(jokes.size) {
            Text(
                text = jokes[it].content,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onBackground,
            )
            Spacer(modifier = Modifier.height(4.dp))
            HorizontalDivider()
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}