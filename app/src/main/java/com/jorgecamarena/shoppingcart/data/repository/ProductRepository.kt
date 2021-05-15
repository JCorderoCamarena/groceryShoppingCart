package com.jorgecamarena.shoppingcart.data.repository

import androidx.lifecycle.LiveData
import com.jorgecamarena.shoppingcart.data.dao.ProductDao
import com.jorgecamarena.shoppingcart.data.entity.Product
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productDao: ProductDao
) {

    val productsCallDirectly: LiveData<List<Product>> = productDao.getProducts()

    fun getProducts(): LiveData<List<Product>> {
        return productDao.getProducts()
    }

    fun getProductsAlphabetically(): LiveData<List<Product>> {
        return productDao.getProductsOrderedByName()
    }

    suspend fun saveProduct(product: Product) {
        productDao.saveProduct(product)
    }

    fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    fun updateProduct(product: Product) {
        productDao.updateProduct(product)
    }

}