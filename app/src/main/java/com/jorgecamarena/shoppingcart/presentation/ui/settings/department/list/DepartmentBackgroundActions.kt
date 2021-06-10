package com.jorgecamarena.shoppingcart.presentation.ui.settings.department.list

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
fun DepartmentBackgroundActions(
    alignment: Alignment,
    coroutineScope: CoroutineScope,
    dismissState: DismissState,
    icon: ImageVector,
    scale: Float,
    onEditDepartment: () -> Unit,
    onDeleteDepartment: () -> Unit

) {
    when(alignment) {
        Alignment.CenterStart -> {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        dismissState.animateTo(DismissValue.Default)
                        onEditDepartment()
                    }
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Edit Department",
                    modifier = Modifier.scale(scale),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
        Alignment.CenterEnd -> {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        dismissState.animateTo(DismissValue.Default)
                    }
                    onDeleteDepartment()
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Delete Department",
                    modifier = Modifier.scale(scale),
                    tint = MaterialTheme.colors.onError
                )
            }
        }
    }

}