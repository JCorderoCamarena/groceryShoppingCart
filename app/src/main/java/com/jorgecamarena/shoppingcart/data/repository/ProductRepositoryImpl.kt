package com.jorgecamarena.shoppingcart.data.repository

import com.jorgecamarena.shoppingcart.data.dao.ProductDao
import com.jorgecamarena.shoppingcart.data.entity.ProductEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepository @Inject constructor(
    private val productDao: ProductDao
) {

    val products: Flow<List<ProductEntity>> = productDao.getProducts()

    suspend fun saveProduct(productEntity: ProductEntity) = productDao.saveProduct(productEntity)

    fun updateProduct(productEntity: ProductEntity) = productDao.updateProduct(productEntity)

    fun deleteProduct(productEntity: ProductEntity) = productDao.deleteProduct(productEntity)

}