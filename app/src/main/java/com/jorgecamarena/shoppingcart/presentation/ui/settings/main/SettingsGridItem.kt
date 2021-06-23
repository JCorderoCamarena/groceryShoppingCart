package com.jorgecamarena.shoppingcart.presentation.ui.settings.main

import androidx.annotation.StringRes
import androidx.compose.ui.graphics.vector.ImageVector

data class SettingsGridItem(
    val icon: ImageVector,
    val iconDescription: String,
    @StringRes val label: Int,
    val action: () -> Unit
)
