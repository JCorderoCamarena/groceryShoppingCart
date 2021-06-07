package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun EditMeasureScreen(
    navHostController: NavHostController,
    measureViewModel: MeasureViewModel,
    measureId: Long
) {

    var measure = measureViewModel.selectedMeasure.observeAsState().value
    measureViewModel.getMeasureById(measureId)

    if (measure?.name != null) {
        Column(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 60.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MeasureForm(
                onCancel = navHostController::navigateUp,
                onSaveMeasure = measureViewModel::updateMeasure,
                measure = measure,
                currentName = measure.name!!
            )
        }
    }

}