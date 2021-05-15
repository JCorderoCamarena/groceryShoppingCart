package com.jorgecamarena.shoppingcart.presentation.ui.settings.main

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FactCheck
import androidx.compose.material.icons.filled.LocalMall
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.SquareFoot
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.jorgecamarena.shoppingcart.presentation.ui.settings.NavigationConstants
import com.jorgecamarena.shoppingcart.presentation.ui.theme.DMSurfaceColor
import com.jorgecamarena.shoppingcart.presentation.ui.theme.SecondaryLightColor


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GridList(gridItems: List<SettingsGridItem>) {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(minSize = 150.dp)
    ) {
        items(gridItems) {
            GridItemCard(it)
        }
    }
}

@Composable
fun GridItemCard(gridItem: SettingsGridItem) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .padding(all = 8.dp)
            .clickable(onClick = gridItem.action)
            .height(130.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier.padding(all = 8.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                imageVector = gridItem.icon,
                contentDescription = gridItem.iconDescription,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(
                        if (isSystemInDarkTheme()) DMSurfaceColor else SecondaryLightColor
                    )
                    .align(Alignment.CenterHorizontally)
                    .padding(all = 16.dp)
                    .size(40.dp)
            )
            Text(
                text = gridItem.label,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 8.dp),
                style = MaterialTheme.typography.body1,
            )
        }
    }
}

fun generateSettingsList(navHostController: NavHostController): List<SettingsGridItem> = listOf(
    SettingsGridItem(
        icon = Icons.Filled.ShoppingCart,
        iconDescription =  "Products",
        label = "Products",
        action =  { navHostController.navigate(NavigationConstants.productsMainScreen) }
    ),
    SettingsGridItem(
        icon = Icons.Filled.SquareFoot,
        iconDescription =  "Measures",
        label = "Measures",
        action = { navHostController.navigate(NavigationConstants.measuresMainScreen) }
    ),
    SettingsGridItem(
        icon = Icons.Filled.LocalMall,
        iconDescription =  "Department",
        label = "Department",
        action = { navHostController.navigate(NavigationConstants.measuresMainScreen) }
    ),
    SettingsGridItem(
        icon = Icons.Filled.FactCheck,
        iconDescription =  "Status",
        label = "Status",
        action = { navHostController.navigate(NavigationConstants.measuresMainScreen) }
    )
)