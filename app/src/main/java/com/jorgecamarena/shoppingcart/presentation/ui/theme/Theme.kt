package com.jorgecamarena.shoppingcart.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.jorgecamarena.shoppingcart.presentation.ui.theme.type.ProductTypography

private val DarkColorPalette = darkColors(
    primary = DMPrimaryColor,
    primaryVariant = DMPrimaryVariantColor,
    secondary = DMSecondaryColor,
    secondaryVariant = DMSecondaryVariantColor,
    background = DMBackgroundColor,
    surface = DMSurfaceColor,
    onPrimary = DMOnPrimary,
    onSecondary = DMOnSecondary,
    onBackground = DMOnBackgroundColor,
    onSurface = DMOnSurfaceColor
)

private val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = PrimaryVariantColor,
    secondary = SecondaryColor,
    secondaryVariant = SecondaryVariantColor,
    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ShoppingCartTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = ProductTypography,
        shapes = Shapes,
        content = content
    )
}
