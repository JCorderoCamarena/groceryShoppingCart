package com.jorgecamarena.shoppingcart.utils

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import com.jorgecamarena.shoppingcart.R


@Stable
fun diagonalGradient(
    colors: List<Color>,
    startX: Float = 0.0f,
    startY: Float = 0.0f,
    endX: Float = Float.POSITIVE_INFINITY,
    endY: Float = Float.POSITIVE_INFINITY,
    tileMode: TileMode = TileMode.Clamp
): Brush = Brush.linearGradient(colors, Offset(startX, startY), Offset(endX, endY), tileMode)


@Composable
fun DiagonalGradientSample() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                diagonalGradient(
                    colors = listOf(
                        MaterialTheme.colors.primary,
                        MaterialTheme.colors.secondary,
                        MaterialTheme.colors.error
                    ),
                    startX = 0.0f,
                    startY = 0.0f
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    diagonalGradient(
                        colors = listOf(
                            Color.Black,
                            Color.White.copy(
                                alpha = 0.1f
                            )
                        ),
                        startX = 0.0f,
                        startY = 0.0f
                    )
                )
        ) {
            Text(
                text = stringResource(id = R.string.title_home),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }

}