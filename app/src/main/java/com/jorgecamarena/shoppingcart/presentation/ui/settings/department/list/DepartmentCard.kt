package com.jorgecamarena.shoppingcart.presentation.ui.settings.department.list

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorgecamarena.shoppingcart.data.entity.Department

@ExperimentalMaterialApi
@Composable
fun DepartmentCard(
    dismissState: DismissState,
    department: Department
) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp),
        elevation = animateDpAsState(
            when {
                isSystemInDarkTheme() -> 0.dp
                dismissState.dismissDirection != null -> 16.dp
                else -> 4.dp
            }
        ).value
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            department.name?.let {
                Text(
                    text = it
                )
            }
        }
    }
}