package com.jorgecamarena.shoppingcart.presentation.ui.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ShoppingSplashScreen(
    onDataLoaded: () -> Unit,
    splashViewModel: SplashViewModel
) {

    if (splashViewModel.isAppReady) {
        onDataLoaded()
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column {
                CircularProgressIndicator()
                Text(text = "Loading...")
            }
        }
    }

}