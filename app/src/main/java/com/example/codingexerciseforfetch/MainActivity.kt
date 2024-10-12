package com.example.codingexerciseforfetch

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.codingexerciseforfetch.ui.FetchApp
import com.example.codingexerciseforfetch.ui.theme.CodingExerciseForFetchTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CodingExerciseForFetchTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FetchApp()
                }
            }
        }
    }
}

