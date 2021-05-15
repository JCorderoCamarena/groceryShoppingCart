package com.jorgecamarena.shoppingcart.presentation.ui

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.jorgecamarena.shoppingcart.R

sealed class ScreenNavItem(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object Home: ScreenNavItem(Routes.Home.name, R.string.title_home, Icons.Filled.Home)
    object Settings: ScreenNavItem(Routes.Settings.name, R.string.title_settings, Icons.Filled.Settings)
    object About: ScreenNavItem(Routes.About.name, R.string.title_about, Icons.Filled.Info)
}
