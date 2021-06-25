package com.jorgecamarena.shoppingcart.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.google.accompanist.insets.ProvideWindowInsets
import com.jorgecamarena.shoppingcart.presentation.ui.splash.ShoppingSplashScreen
import com.jorgecamarena.shoppingcart.presentation.ui.splash.SplashViewModel
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity: ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ShoppingCartTheme {
                ProvideWindowInsets {
                    ShoppingSplashScreen(
                        onDataLoaded = { startApp() },
                        splashViewModel = splashViewModel
                    )
                }
            }
        }
    }

    private fun startApp() {
        val appIntent = Intent(this, MainActivity::class.java)
        startActivity(appIntent)
        finish()
    }

}