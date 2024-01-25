package com.example.australiacityapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.australiacityapp.states.StatesScreen
import com.example.australiacityapp.ui.theme.AustraliaCityAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AustraliaCityAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    StatesScreen()
                }
            }
        }
    }
}