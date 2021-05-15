package com.jorgecamarena.shoppingcart.presentation.ui.settings

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jorgecamarena.shoppingcart.presentation.ui.settings.NavigationConstants.Companion.departmentsMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.NavigationConstants.Companion.measuresMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.NavigationConstants.Companion.productsMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.NavigationConstants.Companion.settingsMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.NavigationConstants.Companion.statusMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.ProductsScreen
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {

    private lateinit var settingsViewModel: SettingsViewModel

    @ExperimentalFoundationApi
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        settingsViewModel =
                ViewModelProvider(this).get(SettingsViewModel::class.java)
        return ComposeView(requireContext()).apply {
            setContent {
                val navController = rememberNavController()
                var showBackButton by remember { mutableStateOf(true) }


                if (showBackButton) {
                    Log.d("TAG", "onCreateView: $showBackButton")
                }
                ShoppingCartTheme {
                    Scaffold(
                        topBar = {
                            TopAppBar(navController = navController, showBackButton = showBackButton)
                        },
                        content = {
                            // SettingsNavigator(navController = navController, onShowBackButton = { showBackButton = it })
                            Text(
                                style = MaterialTheme.typography.h3,
                                text = "Settings",
                                fontWeight = FontWeight.W500
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TopAppBar(navController: NavHostController, showBackButton: Boolean) {
    if (showBackButton) {
        TopAppBar(
            title = {
                Text(
                    style = MaterialTheme.typography.h3,
                    text = "Settings",
                    fontWeight = FontWeight.W500
                )
            },
            navigationIcon = {
                if (showBackButton) {
                    IconButton(onClick = { navController.navigateUp() }) {
                      Icon(
                          imageVector = Icons.Filled.ArrowBack,
                          contentDescription = "Back"
                      )
                    }
                }
            },
            elevation = 8.dp
        )
    } else {
        TopAppBar(
            title = {
                Text(
                    style = MaterialTheme.typography.h3,
                    text = "Settings",
                    fontWeight = FontWeight.W500
                )
            },
            elevation = 8.dp
        )
    }
}

//@ExperimentalFoundationApi
//@Composable
//fun SettingsNavigator(navController: NavHostController, onShowBackButton: (Boolean) -> Unit) {
//    NavHost(
//        navController = navController,
//        startDestination = settingsMainScreen
//    ) {
//        composable(settingsMainScreen) { SettingsMainView(navHostController = navController) }
//        composable(productsMainScreen) { ProductsScreen(navHostController = navController, onShowBackButton) }
//        composable(departmentsMainScreen) { DepartmentsMainView(onShowBackButton) }
//        composable(measuresMainScreen) { MeasuresMainView(onShowBackButton) }
//        composable(statusMainScreen) { StatusMainView(onShowBackButton) }
//    }
//}

class NavigationConstants {
    companion object {
        const val settingsMainScreen      = "SettingsMainScreen"
        const val productsMainScreen      = "ProductsMainScreen"
        const val departmentsMainScreen   = "DepartmentsMainScreen"
        const val measuresMainScreen      = "MeasuresMainScreen"
        const val statusMainScreen        = "StatusMainScreen"
    }
}
