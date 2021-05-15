package com.jorgecamarena.shoppingcart.presentation.ui.settings.product


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.jorgecamarena.shoppingcart.data.entity.ProductEntity
import com.jorgecamarena.shoppingcart.data.repository.ProductRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepositoryImpl
) : ViewModel() {

    val products = productRepository.products.asLiveData()

    var loading by mutableStateOf(false)
        private set


    fun saveProduct(name: String, imageLink: String) {
        loading = true
        val product = ProductEntity()
        val productToSave = product.copy(
            name = name,
            imageLink = imageLink,
            createdAt = System.currentTimeMillis()
        )
        viewModelScope.launch {
            productRepository.saveProduct(productToSave)
            loading = false
        }
    }

}