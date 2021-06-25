package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jorgecamarena.shoppingcart.data.entity.Measure

@ExperimentalMaterialApi
@Composable
fun MeasureList(
    measureList: List<Measure>
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
                MeasureCard(measure = measure)
            }
        }
    }
}