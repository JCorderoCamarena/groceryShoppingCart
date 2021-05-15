package com.jorgecamarena.shoppingcart.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.google.accompanist.insets.ProvideWindowInsets
import com.jorgecamarena.shoppingcart.presentation.ui.ShoppingNavHost
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProvideWindowInsets {
                    ShoppingNavHost()
                }
            }
        }
    }

}
