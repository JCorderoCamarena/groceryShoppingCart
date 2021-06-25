package com.jorgecamarena.shoppingcart.presentation.ui.scaffold

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import androidx.compose.material.TopAppBar
import com.jorgecamarena.shoppingcart.presentation.ui.navigation.ScreenNavItem

@Composable
fun ShoppingTopAppBar(navController: NavHostController, currentRoute: String) {
    val currentScreenNavItem = ScreenNavItem.fromScreenNavString(currentRoute)

    TopAppBar(
        title = {
            Text(
                style = MaterialTheme.typography.h3,
                text = stringResource(id = currentScreenNavItem.resourceId),
                fontWeight = FontWeight.W500
            )
        },
        navigationIcon = currentScreenNavItem.isPartOfBottomBar?.let {
            getNavigationIcon(
                it,
                navController
            )
        }
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