package com.jorgecamarena.shoppingcart.presentation.ui.settings.product.list

import android.util.Log
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.data.entity.Product
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun ProductBackgroundActions(
    navHostController: NavHostController,
    alignment: Alignment,
    deleteProduct: (Product) -> Unit,
    product: Product,
    dismissState: DismissState,
    coroutineScope: CoroutineScope,
    icon: ImageVector,
    scale: Float
) {
    when(alignment) {
        Alignment.CenterStart -> {
            TextButton(
                onClick = {
                    coroutineScope.launch {
                        dismissState.animateTo(DismissValue.Default)
                        navHostController.navigate("editProduct/${product.id}")
                    }
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Edit Product",
                    modifier = Modifier.scale(scale),
                    tint = MaterialTheme.colors.onPrimary
                )
            }
        }
        Alignment.CenterEnd -> {
            TextButton(
                onClick = {
                    Log.d("DEBUG", "ProductsScreen: Delete ${product.name} with id ${product.id}")
                    deleteProduct(product)
                    coroutineScope.launch {
                        dismissState.animateTo(DismissValue.Default)
                    }
                }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = "Localized description",
                    modifier = Modifier.scale(scale),
                    tint = MaterialTheme.colors.onError
                )
            }
        }
    }
}