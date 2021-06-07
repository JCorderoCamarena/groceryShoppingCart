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


    fun getProducts(): LiveData<List<Product>> {
        return productDao.getProducts()
    }

    fun getProductsAlphabetically(): LiveData<List<Product>> {
        return productDao.getProductsOrderedByName()
    }

    fun getProduct(productId: Long): LiveData<Product>? {
        return productDao.getProductById(productId)
    }

    suspend fun saveProduct(product: Product) {
        productDao.saveProduct(
            product.apply {
                createdAt = System.currentTimeMillis()
                modifiedAt = System.currentTimeMillis()
            }
        )
    }

    suspend fun deleteProduct(product: Product) {
        productDao.deleteProduct(product)
    }

    suspend fun updateProduct(product: Product) {
        productDao.updateProduct(
            product.apply {
                modifiedAt = System.currentTimeMillis()
            }
        )
    }

}