package com.co.ceiba.marvelapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.core.content.ContextCompat
import com.co.ceiba.marvelapp.ui.theme.MarvelAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, R.color.black)
            MarvelAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    var loadingSplashScreen by remember {
                        mutableStateOf(true)
                    }
                    Navigation(
                        isLoading = { loadingSplashScreen = it },
                        loadingSplashScreen = loadingSplashScreen
                    )
                }
            }
        }
    }
}

