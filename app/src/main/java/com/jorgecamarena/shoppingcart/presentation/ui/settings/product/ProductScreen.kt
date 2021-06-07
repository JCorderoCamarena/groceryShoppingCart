package com.jorgecamarena.shoppingcart.presentation.ui.settings.product


import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.list.ProductList

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductsScreen(
    productViewModel: ProductViewModel = viewModel(),
    navHostController: NavHostController,
    onShowBackButton: (Boolean) -> Unit
) {
    onShowBackButton(true)

    val productList = productViewModel.products.observeAsState(listOf()).value
    productViewModel.loadProducts()


    if (productViewModel.isLoading && productList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Loading products...")
        }

    } else if (productList.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(stringResource(id = R.string.label_no_products_found))
        }
    } else {
        ProductList(
            products = productList,
            navHostController = navHostController,
            deleteProduct = productViewModel::deleteProduct
        )
    }
}