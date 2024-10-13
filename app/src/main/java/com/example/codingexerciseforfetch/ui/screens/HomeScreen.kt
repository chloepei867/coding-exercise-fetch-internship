package com.example.codingexerciseforfetch.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.codingexerciseforfetch.R
import com.example.codingexerciseforfetch.model.FetchItem
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
//    Image (
//        modifier = modifier.size(200.dp),
//        painter = painterResource(R.drawable.loading_img),
//        contentDescription = stringResource(R.string.loading)
//    )
    Box(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.size(200.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }

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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ResultScreen(
    items: List<FetchItem>,
    modifier: Modifier = Modifier ) {
    val groupedItems = items
//        filter out null or blank names
        .filter{!it.name.isNullOrBlank()}
        .sortedWith(compareBy({it.listId}, {it.name}))
        .groupBy { it.listId }

    // Display the grouped items in a LazyColumn
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 120.dp, start = 16.dp, end = 16.dp),
//        verticalArrangement = Arrangement.spacedBy(40.dp)
    ) {
        groupedItems.forEach { (listId, itemList) ->
            // Group header for each listId
            stickyHeader {
                Text(
                    text = "List ID: $listId",
//                    style = MaterialTheme.typography.h6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.LightGray)
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                )
            }
//            item {
//                Text(
//                    text = "List ID: $listId",
////                    style = MaterialTheme.typography.h6,
//                    modifier = Modifier.padding(vertical = 4.dp)
//                )
//            }

            // Display each item within the current group
            items(itemList) { item ->
                ItemRow(item = item)
            }
        }
    }

}

@Composable
fun ItemRow(item: FetchItem) {
    (Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
//        elevation = 4
    ) {
        Text(
            text = "ID: ${item.id}, listId: ${item.listId}, Name: ${item.name}",
                        modifier = Modifier.padding(8.dp),
            //            style = MaterialTheme.typography.body1
        )
    })
}

//@Preview(showBackground= true)
//@Composable
//fun ResultScreenPreview() {
//    CodingExerciseForFetchTheme {
//        ResultScreen()
//    }
//}

