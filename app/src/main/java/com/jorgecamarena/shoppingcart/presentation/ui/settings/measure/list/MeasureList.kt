package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.list

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.data.entity.Measure
import com.jorgecamarena.shoppingcart.presentation.ui.navigation.ScreenNavItem
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.list.ProductBackgroundActions
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.list.ProductCard
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.widgets.PartialSwipeToDismiss

@ExperimentalMaterialApi
@Composable
fun MeasureList(
    measureList: List<Measure>,
    onDeleteMeasure: (Measure) -> Unit,
    onEditMeasure: (Long?) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 60.dp)
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(measureList) { measure ->
                val dismissState = rememberDismissState()

                val coroutineScope = rememberCoroutineScope()

                PartialSwipeToDismiss(
                    state = dismissState,
                    modifier = Modifier.padding(vertical = 4.dp),
                    directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                    dismissThresholds = { direction ->
                        FractionalThreshold(if (direction == DismissDirection.StartToEnd) 0.25f else 0.5f)
                    },
                    background = {

                        val direction = dismissState.dismissDirection ?: return@PartialSwipeToDismiss

                        val color by animateColorAsState(
                            when (dismissState.targetValue) {
                                DismissValue.Default -> MaterialTheme.colors.background
                                DismissValue.DismissedToEnd -> MaterialTheme.colors.primaryVariant
                                DismissValue.DismissedToStart -> MaterialTheme.colors.error
                            }
                        )

                        val alignment = when (direction) {
                            DismissDirection.StartToEnd -> Alignment.CenterStart
                            DismissDirection.EndToStart -> Alignment.CenterEnd
                        }

                        val icon = when (direction) {
                            DismissDirection.StartToEnd -> Icons.Default.Edit
                            DismissDirection.EndToStart -> Icons.Default.Delete
                        }

                        val scale by animateFloatAsState(
                            if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = color, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 20.dp),
                            contentAlignment = alignment
                        ) {
                            MeasureBackgroundActions(
                                onEditMeasure = { onEditMeasure(measure.id) },
                                alignment = alignment,
                                onDeleteMeasure = { onDeleteMeasure(measure) },
                                dismissState = dismissState,
                                coroutineScope = coroutineScope,
                                scale = scale,
                                icon = icon
                            )
                        }
                    },
                    dismissContent = {
                        MeasureCard(measure = measure, dismissState = dismissState)
                    }
                )

            }
        }
    }
}