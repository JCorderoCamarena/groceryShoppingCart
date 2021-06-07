package com.jorgecamarena.shoppingcart.presentation.ui.settings.product

import android.util.Log
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

    var products: LiveData<List<Product>> = MutableLiveData()

    var productToEdit: LiveData<Product> = MutableLiveData()

    var isLoading by mutableStateOf(false)
        private set

    fun loadProducts() {
        Log.d("DEBUG", "loadProducts() called")
        isLoading = true
        productRepository.getProducts().let {
            products = it
            isLoading = false
        }
    }


    fun saveProduct(name: String, imageLink: String) {
        isLoading = true
        val product = Product(
            name = name,
            imageLink = imageLink,
            measurement = null
        )

        viewModelScope.launch {
            productRepository.saveProduct(product)
            isLoading = false
        }
    }

    fun getProductById(id: Long) {
        productRepository.getProduct(id)?.let {
            productToEdit = it
        }
    }

    fun updateProduct(product: Product) {
        isLoading = true
        viewModelScope.launch {
            productRepository.updateProduct(product)
            isLoading = false
        }
    }

    fun deleteProduct(product: Product) {
        viewModelScope.launch {
            productRepository.deleteProduct(product = product)
        }
    }

}