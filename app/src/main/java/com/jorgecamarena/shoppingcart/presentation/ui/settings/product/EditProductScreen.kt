package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Product

@Composable
fun EditProductScreen(productViewModel: ProductViewModel, navHostController: NavHostController, productId: Long) {

    val product = productViewModel.productToEdit.observeAsState().value
    productViewModel.getProductById(productId)

    if (product != null) {
        ProductEditForm(
            navHostController = navHostController,
            product = product,
            updateProduct = productViewModel::updateProduct
        )
    }
}

@Composable
fun ProductEditForm(
    navHostController: NavHostController,
    product: Product,
    updateProduct: (Product) -> Unit
) {
    var name by remember { mutableStateOf(product.name ?: "") }
    var imageLink by remember { mutableStateOf(product.imageLink ?: "") }

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)
    ) {

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
                    val editedProduct = product.copy(
                        name = name,
                        imageLink = imageLink
                    )
                    updateProduct(editedProduct)
                    navHostController.navigateUp()
                },
                enabled = name.isNotBlank() && imageLink.isNotBlank()
            ) {
                Text(text = stringResource(id = R.string.label_save))
            }
        }

    }
}