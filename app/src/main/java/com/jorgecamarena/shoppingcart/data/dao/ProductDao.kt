package com.jorgecamarena.shoppingcart.data.dao

import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getProducts(): Flow<List<ProductEntity>>

    @Insert
    suspend fun saveProduct(productEntity: ProductEntity)

    @Update
    fun updateProduct(productEntity: ProductEntity)

    @Delete
    fun deleteProduct(productEntity: ProductEntity)
}