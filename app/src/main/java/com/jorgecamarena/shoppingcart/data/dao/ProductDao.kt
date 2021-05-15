package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getProducts(): LiveData<List<Product>>

     @Query("SELECT * FROM products ORDER BY product_name ASC")
    fun getProductsOrderedByName(): LiveData<List<Product>>

    @Insert
    suspend fun saveProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}