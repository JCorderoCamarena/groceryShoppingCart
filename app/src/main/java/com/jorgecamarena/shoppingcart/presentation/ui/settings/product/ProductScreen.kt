package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import android.util.Log
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Product
import com.jorgecamarena.shoppingcart.presentation.ui.settings.product.widgets.PartialSwipeToDismiss
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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


    if (productViewModel.loading && productList.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(text = "Loading products...")
            }
        }
    } else if (productList.isEmpty()) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Row(horizontalArrangement = Arrangement.Center) {
                Text(stringResource(id = R.string.label_no_products_found))
            }
        }
    } else {
        ProductList(
            products = productList,
            navHostController = navHostController,
            deleteProduct = productViewModel::deleteProduct
        )
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ProductList(
    products: List<Product>,
    navHostController: NavHostController,
    deleteProduct: (Product) -> Unit
) {
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

                val dismissState = rememberDismissState()

                val coroutineScope = rememberCoroutineScope()

                PartialSwipeToDismiss(
                    state = dismissState,
                    modifier = Modifier.padding(vertical = 4.dp),
                    directions = setOf(DismissDirection.StartToEnd, DismissDirection.EndToStart),
                    dismissThresholds = { direction ->
                        FractionalThreshold(if (direction == DismissDirection.StartToEnd) 0.25f else 0.5f)
                    },
                    background = {

                        val direction = dismissState.dismissDirection ?: return@PartialSwipeToDismiss

                        val color by animateColorAsState(
                            when (dismissState.targetValue) {
                                DismissValue.Default -> MaterialTheme.colors.background
                                DismissValue.DismissedToEnd -> MaterialTheme.colors.primaryVariant
                                DismissValue.DismissedToStart -> MaterialTheme.colors.error
                            }
                        )

                        val alignment = when (direction) {
                            DismissDirection.StartToEnd -> Alignment.CenterStart
                            DismissDirection.EndToStart -> Alignment.CenterEnd
                        }

                        val icon = when (direction) {
                            DismissDirection.StartToEnd -> Icons.Default.Edit
                            DismissDirection.EndToStart -> Icons.Default.Delete
                        }

                        val scale by animateFloatAsState(
                            if (dismissState.targetValue == DismissValue.Default) 0.75f else 1f
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = color, shape = RoundedCornerShape(8.dp))
                                .padding(horizontal = 20.dp),
                            contentAlignment = alignment
                        ) {
                            ProductBackgroundActions(
                                navHostController = navHostController,
                                alignment = alignment,
                                deleteProduct = deleteProduct,
                                product = product,
                                dismissState = dismissState,
                                coroutineScope = coroutineScope,
                                icon = icon,
                                scale = scale
                            )
                        }
                    },
                    dismissContent = {
                        ProductCard(modifier = Modifier, product = product, dismissState = dismissState)
                    }
                )
            }
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun ProductCard(modifier: Modifier, product: Product, dismissState: DismissState) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = RoundedCornerShape(5.dp),
        elevation = animateDpAsState(
            when {
                isSystemInDarkTheme() -> 0.dp
                dismissState.dismissDirection != null -> 16.dp
                else -> 4.dp
            }
        ).value
    ) {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            val painter = rememberCoilPainter(
                request = product.imageLink,
                fadeIn = true,
                previewPlaceholder = R.drawable.ic_image_placeholder
            )

            when(painter.loadState) {
                is ImageLoadState.Loading -> {
                    Image(
                        painter = painterResource(id = R.drawable.ic_image_placeholder),
                        contentDescription = product.name
                    )
                }
            }

            Image(
                modifier = modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.4f)
                    .clip(shape = RoundedCornerShape(5.dp)),
                painter = painter,
                contentDescription = product.name,
                contentScale = ContentScale.Crop
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                product.name?.let {
                    Text(
                        modifier= Modifier.padding(all = 8.dp),
                        text = it
                    )
                }
            }
        }

    }
}


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
                       navHostController.navigate("Edit Product/${product.id}")
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
//                   productViewModel.deleteProduct(product)
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