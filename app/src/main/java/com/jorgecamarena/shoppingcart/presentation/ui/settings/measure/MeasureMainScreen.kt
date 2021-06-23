package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams
import com.jorgecamarena.shoppingcart.presentation.ui.settings.measure.list.MeasureList

@ExperimentalMaterialApi
@Composable
fun MeasureMainScreen(
    navHostController: NavHostController,
    measureViewModel: MeasureViewModel
) {

    val measureList = measureViewModel.measureList.observeAsState(listOf()).value

    if (measureViewModel.isLoading && measureList.isEmpty()) {
        // TODO: Replace with shimmer animation
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Loading Measures.. replace with Shimmer animation"
            )
        }
    } else if(measureList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.label_no_measures_found)
            )
        }
    } else {
        MeasureList(
            measureList = measureList,
            onDeleteMeasure = measureViewModel::deleteMeasure,
            onEditMeasure =  { it?.let { navHostController.navigate(RoutesWithParams.getEditMeasureRoute("$it")) } }
        )
    }
}