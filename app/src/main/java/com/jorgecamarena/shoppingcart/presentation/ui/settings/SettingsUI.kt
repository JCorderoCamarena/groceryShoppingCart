package com.jorgecamarena.shoppingcart.presentation.ui.settings

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.presentation.ui.settings.main.GridList
import com.jorgecamarena.shoppingcart.presentation.ui.settings.main.generateSettingsList


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SettingsMainView(navHostController: NavHostController) {
    val gridItems = generateSettingsList(navHostController)


    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(all = 16.dp)
    ) {
        GridList(gridItems = gridItems)
    }
}


@Composable
fun StatusMainView(onShowBackButton: (Boolean) -> Unit) {
    onShowBackButton(true)
    Text(text = "Status")
}