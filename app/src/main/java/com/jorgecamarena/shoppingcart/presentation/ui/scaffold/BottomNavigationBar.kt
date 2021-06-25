package com.jorgecamarena.shoppingcart.presentation.ui.scaffold

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.presentation.ui.navigation.ScreenNavItem

@Composable
fun ShoppingBottomNavigationBar(
    bottomBarItems: List<ScreenNavItem>,
    currentRoute: String?,
    navController: NavHostController
) {
    BottomNavigation {
        bottomBarItems.forEach { screen ->

            val routeInstance = currentRoute?.let {
                ScreenNavItem.fromScreenNavString(it)
            }

            BottomNavigationItem(
                icon = { Icon(screen.icon, contentDescription = null) },
                label = { Text(stringResource(screen.resourceId)) },
                selected = routeInstance?.item == screen.item || routeInstance?.parentRoute == screen.item,
                onClick = {
                    navController.navigate(screen.item.route) {
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
}