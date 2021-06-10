package com.jorgecamarena.shoppingcart.presentation.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.jorgecamarena.shoppingcart.presentation.ui.about.AboutView
import com.jorgecamarena.shoppingcart.presentation.ui.home.HomeView
import com.jorgecamarena.shoppingcart.presentation.ui.navigation.ScreenNavItem
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


@ExperimentalMaterialApi
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ShoppingNavHost() {
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
                    TopAppBar(
                        navController = navController,
                        currentRoute = currentRoute
                    )
                }
            }
        },
        bottomBar = {
            BottomNavigation {
                bottomBarItems.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(screen.icon, contentDescription = null) },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentRoute == screen.route || currentRoute?.let {
                            ScreenNavItem.fromScreenNavString(
                                it
                            ).parentRoute
                        } == screen.item,
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
            FloatingActionComponent(navHostController = navController, currentRoute = currentRoute)
        }
    ) {
        NavHost(navController = navController, startDestination = ScreenNavItem.Home.route) {
            composable(ScreenNavItem.Home.route) {
                HomeView()
            }
            composable(ScreenNavItem.Settings.route) {
                SettingsMainView(navHostController = navController)
            }
            composable(ScreenNavItem.About.route) {
                AboutView()
            }
            composable(ScreenNavItem.ProductList.route) {
                val productViewModel = hiltViewModel<ProductViewModel>()
                ProductsScreen(
                    productViewModel = productViewModel,
                    navHostController = navController
                ) {}
            }
            composable(ScreenNavItem.DepartmentList.route) {
                val departmentViewModel = hiltViewModel<DepartmentViewModel>()
                DepartmentMainScreen(
                    departmentViewModel = departmentViewModel,
                    navHostController = navController
                )
            }
            composable(ScreenNavItem.DepartmentAdd.route) {
                val departmentViewModel = hiltViewModel<DepartmentViewModel>()
                AddDepartmentScreen(
                    departmentViewModel = departmentViewModel,
                    navHostController = navController
                )
            }
            composable(
                ScreenNavItem.DepartmentEdit.route,
                arguments = listOf(navArgument("departmentId") {
                    type = NavType.LongType
                })
            ) {
                it.arguments?.getLong("departmentId")?.let { id ->
                    val departmentViewModel = hiltViewModel<DepartmentViewModel>()
                    EditDepartmentScreen(
                        departmentViewModel = departmentViewModel,
                        navHostController = navController,
                        idDepartment = id
                    )
                }
            }
            composable(ScreenNavItem.MeasureList.route) {
                val measureViewModel = hiltViewModel<MeasureViewModel>()
                MeasureMainScreen(
                    navHostController = navController,
                    measureViewModel = measureViewModel
                )
            }
            composable(ScreenNavItem.MeasureAdd.route) {
                val measureViewModel = hiltViewModel<MeasureViewModel>()
                AddMeasureScreen(
                    navHostController = navController,
                    measureViewModel = measureViewModel
                )
            }
            composable(
                ScreenNavItem.MeasureEdit.route,
                arguments = listOf(navArgument("measureId") {
                    type = NavType.LongType
                })
            ) {
                it.arguments?.getLong("measureId")?.let {
                    id ->
                    val measureViewModel = hiltViewModel<MeasureViewModel>()
                    EditMeasureScreen(
                        navHostController = navController,
                        measureViewModel = measureViewModel,
                        measureId = id
                    )
                }
            }
            composable(ScreenNavItem.StatusList.route) {
                StatusMainView { }
            }
            composable(ScreenNavItem.ProductAdd.route) {
                val productViewModel = hiltViewModel<ProductViewModel>()
                AddProductScreen(
                    productViewModel = productViewModel,
                    navHostController = navController
                )
            }
            composable(
                ScreenNavItem.ProductEdit.route,
                arguments = listOf(navArgument("productId") {
                    type = NavType.LongType
                })
            ) {
                it.arguments?.getLong("productId")?.let { id ->
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
}

@Composable
fun TopAppBar(navController: NavHostController, currentRoute: String) {
    val currentScreenNavItem = ScreenNavItem.fromScreenNavString(currentRoute)

    TopAppBar(
        title = {
            Text(
                style = MaterialTheme.typography.h3,
                text = stringResource(id = currentScreenNavItem.resourceId),
                fontWeight = FontWeight.W500
            )
        },
        navigationIcon = currentScreenNavItem.isPartOfBottomBar?.let { getNavigationIcon(it, navController) }
    )
}

fun getNavigationIcon(isPartOfBottomBar: Boolean, navController: NavHostController): @Composable (() -> Unit)? {
    if (isPartOfBottomBar) return null
    return {
        IconButton(onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
    }
}
