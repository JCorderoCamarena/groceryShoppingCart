package com.jorgecamarena.shoppingcart.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.jorgecamarena.shoppingcart.presentation.ui.about.AboutView
import com.jorgecamarena.shoppingcart.presentation.ui.home.HomeView
import com.jorgecamarena.shoppingcart.presentation.ui.settings.*
import com.jorgecamarena.shoppingcart.presentation.ui.settings.department.AddDepartmentScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.department.DepartmentMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.department.DepartmentViewModel
import com.jorgecamarena.shoppingcart.presentation.ui.settings.department.EditDepartmentScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.AddMeasureScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.EditMeasureScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.MeasureMainScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.MeasureViewModel
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.AddProductScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.EditProductScreen
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.ProductViewModel
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.ProductsScreen
import com.jorgecamarena.shoppingcart.utils.DEPARTMENT_ID
import com.jorgecamarena.shoppingcart.utils.MEASURE_ID
import com.jorgecamarena.shoppingcart.utils.PRODUCT_ID


@ExperimentalMaterialApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingNavHostRoutes(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeView()
        }
        composable(Routes.Settings.route) {
            SettingsMainView(navHostController = navController)
        }
        composable(Routes.About.route) {
            AboutView()
        }
        composable(Routes.ProductList.route) {
            val productViewModel = hiltViewModel<ProductViewModel>()
            ProductsScreen(
                productViewModel = productViewModel,
                navHostController = navController
            )
        }
        composable(Routes.DepartmentList.route) {
            val departmentViewModel = hiltViewModel<DepartmentViewModel>()
            DepartmentMainScreen(
                departmentViewModel = departmentViewModel,
                navHostController = navController
            )
        }
        composable(Routes.DepartmentAdd.route) {
            val departmentViewModel = hiltViewModel<DepartmentViewModel>()
            AddDepartmentScreen(
                departmentViewModel = departmentViewModel,
                navHostController = navController
            )
        }
        composable(
            Routes.DepartmentEdit.route,
            arguments = listOf(navArgument(DEPARTMENT_ID) {
                type = NavType.LongType
            })
        ) {
            it.arguments?.getLong(DEPARTMENT_ID)?.let { id ->
                val departmentViewModel = hiltViewModel<DepartmentViewModel>()
                EditDepartmentScreen(
                    departmentViewModel = departmentViewModel,
                    navHostController = navController,
                    idDepartment = id
                )
            }
        }
        composable(Routes.MeasuresList.route) {
            val measureViewModel = hiltViewModel<MeasureViewModel>()
            MeasureMainScreen(
                measureViewModel = measureViewModel
            )
        }
        composable(Routes.MeasuresAdd.route) {
            val measureViewModel = hiltViewModel<MeasureViewModel>()
            AddMeasureScreen(
                navHostController = navController,
                measureViewModel = measureViewModel
            )
        }
        composable(
            Routes.MeasuresEdit.route,
            arguments = listOf(navArgument(MEASURE_ID) {
                type = NavType.LongType
            })
        ) {
            it.arguments?.getLong(MEASURE_ID)?.let {
                id ->
                val measureViewModel = hiltViewModel<MeasureViewModel>()
                EditMeasureScreen(
                    navHostController = navController,
                    measureViewModel = measureViewModel,
                    measureId = id
                )
            }
        }
        composable(Routes.StatusList.route) {
            StatusMainView { }
        }
        composable(Routes.ProductAdd.route) {
            val productViewModel = hiltViewModel<ProductViewModel>()
            AddProductScreen(
                productViewModel = productViewModel,
                navHostController = navController
            )
        }
        composable(
            Routes.ProductEdit.route,
            arguments = listOf(navArgument(PRODUCT_ID) {
                type = NavType.LongType
            })
        ) {
            it.arguments?.getLong(PRODUCT_ID)?.let { id ->
                val productViewModel = hiltViewModel<ProductViewModel>()
                EditProductScreen(
                    productViewModel = productViewModel,
                    navHostController = navController,
                    productId = id
                )
            }
        }
    }
}
