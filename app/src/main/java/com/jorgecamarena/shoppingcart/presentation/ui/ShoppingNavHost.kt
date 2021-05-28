package com.jorgecamarena.shoppingcart.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.google.accompanist.insets.navigationBarsPadding
import com.jorgecamarena.shoppingcart.presentation.ui.about.AboutView
import com.jorgecamarena.shoppingcart.presentation.ui.home.HomeView
import com.jorgecamarena.shoppingcart.presentation.ui.settings.*
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.AddProductScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.ProductViewModel
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.ProductsScreen


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingNavHost() {
    val navController = rememberNavController()

    val items = listOf(
        ScreenNavItem.Home,
        ScreenNavItem.Settings,
        ScreenNavItem.About
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val showBackButton by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar {
                currentRoute?.let {
                    TopAppBar(
                        navController = navController,
                        showBackButton = showBackButton,
                        title = it
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigation {
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                // Pop up to the start destination of the graph to
                                // avoid building up a large stack of destinations
                                // on the back stack as users select items
                                popUpTo(navController.graph.startDestinationId)
                                // Avoid multiple copies of the same destination when
                                // reselecting the same item
                                launchSingleTop = true
                                // Restore state when reselecting a previously selected item
                                restoreState = true
                            }
                        }
                    )
                }
            }
        },
        floatingActionButton = {
            if (currentRoute == NavigationConstants.productsMainScreen) {
                FloatingActionButton(onClick = { navController.navigate("Add Product") }) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Product")
                }
            }
        },
        modifier = Modifier
            .navigationBarsPadding()
    ) {
        NavHost(navController = navController, startDestination = ScreenNavItem.Home.route) {
            composable(ScreenNavItem.Home.route) {
//                val homeViewModel = hiltNavGraphViewModel<HomeViewModel>()
                HomeView()
            }
            composable(ScreenNavItem.Settings.route) {
//                val settingsViewModel = hiltNavGraphViewModel<SettingsViewModel>()
                SettingsMainView(navHostController = navController)
            }
            composable(ScreenNavItem.About.route) {
                AboutView()
            }
            // TODO: Clean Routes Below Here
            composable(NavigationConstants.settingsMainScreen) {
                SettingsMainView(navHostController = navController)
            }
            composable(NavigationConstants.productsMainScreen) {
                val productViewModel = hiltViewModel<ProductViewModel>()
                ProductsScreen(
                    productViewModel = productViewModel
                ) {}
            }
            composable(NavigationConstants.departmentsMainScreen) {
                DepartmentsMainView { }
            }
            composable(NavigationConstants.measuresMainScreen) {
                MeasuresMainView { }
            }
            composable(NavigationConstants.statusMainScreen) {
                StatusMainView { }
            }
            composable("Add Product") {
                val productViewModel = hiltViewModel<ProductViewModel>()
                AddProductScreen(
                    productViewModel = productViewModel,
                    navHostController = navController
                )
            }
        }
    }
}

@Composable
fun TopAppBar(navController: NavHostController, showBackButton: Boolean, title: String) {
    if (showBackButton) {
        TopAppBar(
            title = {
                Text(
                    style = MaterialTheme.typography.h3,
                    text = title,
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
                    text = title,
                    fontWeight = FontWeight.W500
                )
            },
            elevation = 8.dp
        )
    }
}

class NavigationConstants {
    companion object {
        const val settingsMainScreen      = "SettingsMainScreen"
        const val productsMainScreen      = "ProductsMainScreen"
        const val departmentsMainScreen   = "DepartmentsMainScreen"
        const val measuresMainScreen      = "MeasuresMainScreen"
        const val statusMainScreen        = "StatusMainScreen"
    }
}


