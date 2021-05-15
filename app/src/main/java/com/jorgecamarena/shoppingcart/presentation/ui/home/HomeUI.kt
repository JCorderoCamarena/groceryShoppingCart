package com.jorgecamarena.shoppingcart.presentation.ui.home

import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme

@Composable
fun HomeView() {
    Text(
        text = "Home"
    )
}


@Preview(showBackground = true)
@Composable
fun HomeFragmentPreview() {
    ShoppingCartTheme() {
        Surface {
//            HomeView(nu)
        }
    }
}