package com.example.codingexerciseforfetch.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.codingexerciseforfetch.ui.theme.CodingExerciseForFetchTheme

@Composable
fun HomeScreen(
    fetchUiState: String,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    ResultScreen(fetchUiState, modifier.padding(top = contentPadding.calculateTopPadding()))

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
