package com.jorgecamarena.shoppingcart.presentation.ui.settings.main

import androidx.compose.ui.graphics.vector.ImageVector

data class SettingsGridItem(
    val icon: ImageVector,
    val iconDescription: String,
    val label: String,
    val action: () -> Unit
)
