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
    if (currentRoute == Routes.ProductList.route) {
        FloatingActionButton(onClick = { navHostController.navigate(Routes.ProductAdd.route) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Add Product")
        }
    } else if (currentRoute == Routes.MeasuresList.route) {
        FloatingActionButton(onClick = { navHostController.navigate(Routes.MeasuresAdd.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Measure" )
        }
    } else if (currentRoute == Routes.DepartmentList.route) {
        FloatingActionButton(onClick = { navHostController.navigate(Routes.DepartmentAdd.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = "Add Department" )
        }
    }
}