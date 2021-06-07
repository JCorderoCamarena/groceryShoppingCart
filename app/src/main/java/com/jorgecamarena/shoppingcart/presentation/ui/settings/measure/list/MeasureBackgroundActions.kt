package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.list

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun MeasureBackgroundActions(
    onEditMeasure: () -> Unit,
    alignment: Alignment,
    onDeleteMeasure: () -> Unit,
    dismissState: DismissState,
    coroutineScope: CoroutineScope,
    scale: Float,
    icon: ImageVector
) {
    when(alignment) {
        Alignment.CenterStart -> {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        dismissState.animateTo(DismissValue.Default)
                        onEditMeasure()
                    }
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Edit Measure",
                    modifier = Modifier.scale(scale),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
        Alignment.CenterEnd -> {
            TextButton(
                onClick = {
                    onDeleteMeasure()
                    coroutineScope.launch {
                        dismissState.animateTo(DismissValue.Default)
                    }
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Delete Measure",
                    modifier = Modifier.scale(scale),
                    tint = MaterialTheme.colors.onError
                )
            }
        }
    }
}