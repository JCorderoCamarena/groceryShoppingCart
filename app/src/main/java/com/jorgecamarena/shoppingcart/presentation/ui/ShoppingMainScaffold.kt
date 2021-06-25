package com.jorgecamarena.shoppingcart.presentation.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.jorgecamarena.shoppingcart.presentation.ui.navigation.ScreenNavItem
import com.jorgecamarena.shoppingcart.presentation.ui.scaffold.FloatingActionComponent
import com.jorgecamarena.shoppingcart.presentation.ui.scaffold.ShoppingBottomNavigationBar
import com.jorgecamarena.shoppingcart.presentation.ui.scaffold.ShoppingTopAppBar


@ExperimentalMaterialApi
@Composable
fun ShoppingMainScaffold() {
    val navController = rememberNavController()

    val bottomBarItems = listOf(
        ScreenNavItem.Home,
        ScreenNavItem.Settings,
        ScreenNavItem.About
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            TopAppBar {
                currentRoute?.let {
                    ShoppingTopAppBar(
                        navController = navController,
                        currentRoute = currentRoute
                    )
                }
            }
        },
        bottomBar = {
            ShoppingBottomNavigationBar(
                bottomBarItems = bottomBarItems,
                currentRoute = currentRoute,
                navController = navController
            )
        },
        floatingActionButton = {
            FloatingActionComponent(navHostController = navController, currentRoute = currentRoute)
        }
    ) {
        ShoppingNavHostRoutes(navController = navController)
    }
}