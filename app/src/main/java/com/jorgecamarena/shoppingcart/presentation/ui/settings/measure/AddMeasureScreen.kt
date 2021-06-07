package com.jorgecamarena.shoppingcart.presentation.ui.settings.measure

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Measure
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

@Composable
fun AddMeasureScreen(
    navHostController: NavHostController,
    measureViewModel: MeasureViewModel
) {
    Log.d(
        "DEBUG",
        "AddMeasureScreen() called with: navHostController = $navHostController, measureViewModel = $measureViewModel"
    )

    val measure = measureViewModel.selectedMeasure.observeAsState(Measure(name = "")).value

    Column(
        modifier = Modifier
            .padding(top = 8.dp, bottom = 60.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeasureForm(
            onCancel = navHostController::navigateUp,
            onSaveMeasure = measureViewModel::insertMeasure,
            measure = measure
        )
    }
}

@Composable
fun MeasureForm(
    onCancel: () -> Unit,
    onSaveMeasure: (Measure) -> Unit,
    measure: Measure,
    currentName: String = ""
) {

    var name by remember { mutableStateOf(currentName) }

    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        label = { Text(text = stringResource(id = R.string.label_name))}
    )

    Spacer(modifier = Modifier.size(32.dp))

    Row(
        modifier = Modifier.fillMaxWidth(0.8f),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Button(onClick = { onCancel() }) {
            Text(text = stringResource(id = R.string.label_cancel))
        }

        Button(
            onClick = {
                onSaveMeasure(
                    measure.apply {
                        this.name = name
                    }
                )
                onCancel()
            },
            enabled = name.isNotBlank()
        ) {
            Text(text = stringResource(id = R.string.label_save))
        }
    }

}