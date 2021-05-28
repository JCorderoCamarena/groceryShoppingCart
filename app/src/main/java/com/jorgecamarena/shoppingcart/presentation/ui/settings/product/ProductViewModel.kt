package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgecamarena.shoppingcart.data.entity.Product
import com.jorgecamarena.shoppingcart.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    var products: LiveData<List<Product>> = MutableLiveData<List<Product>>()

    fun getProducts() {
        products = productRepository.getProducts()
    }

    var loading by mutableStateOf(false)
        private set

    fun saveProduct(name: String, imageLink: String) {
        loading = true
        val product = Product(
            id = null,
            name = name,
            imageLink = imageLink,
            measurement = null,
            createdAt = System.currentTimeMillis(),
            modifiedAt = null
        )
        viewModelScope.launch {
            productRepository.saveProduct(product)
            loading = false
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            productRepository.deleteProduct(product = product)
        }
    }

}