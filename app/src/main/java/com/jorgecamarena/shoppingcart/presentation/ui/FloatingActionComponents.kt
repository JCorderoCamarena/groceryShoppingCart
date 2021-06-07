package com.jorgecamarena.shoppingcart.presentation.ui

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.presentation.ui.navigation.ScreenNavItem

@Composable
fun FloatingActionComponent(
    navHostController: NavHostController,
    currentRoute: String? = null
) {
    if (currentRoute == ScreenNavItem.ProductList.route) {
        FloatingActionButton(onClick = { navHostController.navigate(ScreenNavItem.ProductAdd.route) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Product")
        }
    } else if (currentRoute == ScreenNavItem.MeasureList.route) {
        FloatingActionButton(onClick = { navHostController.navigate(ScreenNavItem.MeasureAdd.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Measure" )
        }
    }
}