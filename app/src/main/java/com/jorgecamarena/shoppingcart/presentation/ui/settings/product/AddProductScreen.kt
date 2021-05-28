package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R

@Composable
fun AddProductScreen(productViewModel: ProductViewModel, navHostController: NavHostController) {
    
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {
        
        var name by remember { mutableStateOf("") }
        var imageLink by remember { mutableStateOf("") }
        
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text(stringResource(id = R.string.product_name)) }
        )

        OutlinedTextField(
            value = imageLink,
            onValueChange = { imageLink = it },
            label = { Text(stringResource(id = R.string.label_image_link)) }
        )

        Spacer(modifier = Modifier.size(16.dp))

        Row {
            Button(onClick = { navHostController.navigateUp() }) {
                Text(text = stringResource(id = R.string.label_cancel))
            }

            Button(
                onClick = {
                    productViewModel.saveProduct(name = name, imageLink = imageLink)
                    navHostController.navigateUp()
                },
                enabled = name.isNotBlank() && imageLink.isNotBlank()
            ) {
                Text(text = stringResource(id = R.string.label_save))
            }
        }

    }

}