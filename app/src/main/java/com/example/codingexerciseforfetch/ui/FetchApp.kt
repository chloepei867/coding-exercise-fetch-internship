package com.example.codingexerciseforfetch.ui

import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.example.codingexerciseforfetch.R
import com.example.codingexerciseforfetch.ui.screens.FetchViewModel
import com.example.codingexerciseforfetch.ui.screens.HomeScreen
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchApp() {
//    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold (
//        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
//        topBar =  @androidx.compose.runtime.Composable {FetchTopAppBar()}
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        color = colorResource(R.color.white),
                        fontWeight = FontWeight.Bold
                    )
                },
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = colorResource(R.color.fetch_yellow)
                )
            )
        }
    ){
        val fetchViewModel: FetchViewModel = viewModel()
        HomeScreen(
            fetchUiState = fetchViewModel.fetchUiState,
            contentPadding = it,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchTopAppBar() {
    CenterAlignedTopAppBar(
//        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineSmall,
            )
        },
//        modifier = modifier
    )
}