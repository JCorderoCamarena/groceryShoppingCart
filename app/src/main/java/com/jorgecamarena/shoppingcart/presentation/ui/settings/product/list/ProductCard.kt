package com.jorgecamarena.shoppingcart.presentation.ui.settings.product.list

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter
import com.google.accompanist.imageloading.ImageLoadState
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Product

@ExperimentalMaterialApi
@Composable
fun ProductCard(modifier: Modifier, product: Product, dismissState: DismissState) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        shape = MaterialTheme.shapes.medium,
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
                Text(
                    modifier= Modifier.padding(all = 8.dp),
                    text = product.name
                )
            }
        }

    }
}