package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Product

@Composable
fun ProductsScreen(productViewModel: ProductViewModel = viewModel(), onShowBackButton: (Boolean) -> Unit) {
    onShowBackButton(true)

    val products = productViewModel.products.observeAsState().value

    if (products != null) {
        for (product in products) {
            Log.d("ProductScreen", "ProductsScreen: ${product.name}")
        }
    }

    if (products == null || products.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(stringResource(id = R.string.label_no_products_found))
            }
        }
    } else {
        Column(
            modifier = Modifier
                .systemBarsPadding()
                .navigationBarsPadding()
                .padding(top = 8.dp, bottom = 60.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(products) { product ->
                   ProductCard(modifier = Modifier.fillMaxWidth(), product = product)
                }
            }
        }
    }
}

@Composable
fun ProductCard(modifier: Modifier, product: Product) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(5.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            product.name?.let { Text(text = it) }
        }
    }
}