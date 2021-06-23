package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Measure
import com.jorgecamarena.shoppingcart.data.entity.Product

@Composable
fun AddProductScreen(
    productViewModel: ProductViewModel,
    navHostController: NavHostController
) {
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        var name by remember { mutableStateOf("") }

        var imageLink by remember { mutableStateOf("") }
        
        var expanded by remember { mutableStateOf(false) }

        var measureSelected by remember { mutableStateOf("") }

        AddProductForm(
            product = Product(),
            name = name,
            measureSelected = measureSelected,
            measures = listOf(
                Measure(1,"Test"),
                Measure(2,"Test2"),
                Measure(3,"Test3"),
                Measure(4,"Test4")
            ),
            imageLink = imageLink,
            expanded = expanded,
            onUpdateName = { name = it },
            onUpdateImageLink = { imageLink = it },
            onSaveProduct = productViewModel::saveProduct,
            onCancel = navHostController::navigateUp,
            onExpandedChange = { expanded = it },
            onMeasureSelected = { measureSelected = it }
        )

    }
}

@Composable
fun AddProductForm(
    product: Product,
    name: String,
    measureSelected: String,
    measures: List<Measure>,
    imageLink: String,
    expanded: Boolean,
    onUpdateName: (String) -> Unit,
    onUpdateImageLink: (String) -> Unit,
    onSaveProduct: (Product) -> Unit,
    onCancel: () -> Unit,
    onExpandedChange: (Boolean) -> Unit,
    onMeasureSelected: (String) -> Unit
) {

    val icon = if (expanded)
        Icons.Filled.ArrowDropUp
    else
        Icons.Filled.ArrowDropDown

    OutlinedTextField(
        value = name,
        onValueChange = onUpdateName,
        label = { Text(stringResource(id = R.string.product_name)) }
    )

    Box {
        OutlinedTextField(
            value = measureSelected,
            onValueChange = { },
            label = {Text("Measure")},
            trailingIcon = {
                Icon(icon,"contentDescription", Modifier.clickable { onExpandedChange(!expanded) })
            },
            readOnly = true
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { onExpandedChange(false) },
            modifier = Modifier.fillMaxWidth()
        ) {
            measures.forEach { measure ->
                DropdownMenuItem(
                    onClick = {
                        Log.d("DEBUG", "AddProductForm: $measure")
                        onMeasureSelected(measure.name)
                        onExpandedChange(!expanded)
                    }
                ) {
                    Text(text = measure.name)
                }
            }
        }
    }

    OutlinedTextField(
        value = imageLink,
        onValueChange = onUpdateImageLink,
        label = { Text(stringResource(id = R.string.label_image_link)) }
    )

    Spacer(modifier = Modifier.size(16.dp))

    Row {
        Button(
            onClick = {
                onSaveProduct(
                        product.apply {
                        this.name = name
                        this.imageLink = imageLink
                    }
                )
                onCancel()
            },
            enabled = name.isNotBlank() && imageLink.isNotBlank()
        ) {
            Text(text = stringResource(id = R.string.label_save))
        }
    }
}