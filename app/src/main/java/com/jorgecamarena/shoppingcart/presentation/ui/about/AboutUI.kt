package com.jorgecamarena.shoppingcart.presentation.ui.about

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme

@Composable
fun AboutView() {

    var properties: List<Pair<String, String>> = listOf(
        Pair("Version", "1.0"),
        Pair("Status", "Develop"),
        Pair("Credits", "Jorge Camarena"),
    )

    LazyColumn {
        items(properties) { it ->
           Row {
               Text(text = it.first, style = MaterialTheme.typography.h4)
               Text(text = it.second, style = MaterialTheme.typography.body1)
           }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun AboutFragmentPreview() {
    ShoppingCartTheme {
        Surface {
            AboutView()
        }
    }
}