package com.example.codingexerciseforfetch.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.codingexerciseforfetch.R
import com.example.codingexerciseforfetch.ui.theme.CodingExerciseForFetchTheme

@Composable
fun HomeScreen(
    fetchUiState: FetchUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (fetchUiState) {
        is FetchUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxWidth())
        is FetchUiState.Success -> ResultScreen(
            fetchUiState.items,
            modifier = modifier.fillMaxWidth()
        )
        is FetchUiState.Error -> ErrorScreen(modifier = modifier.fillMaxWidth())
    }

}


@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image (
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )

}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }

}

@Composable
fun ResultScreen(
    items: String,
    modifier: Modifier = Modifier ) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
    ) {
        Text(text = items)
    }
}

@Preview(showBackground= true)
@Composable
fun ResultScreenPreview() {
    CodingExerciseForFetchTheme {
        ResultScreen("placeholder")
    }
}
