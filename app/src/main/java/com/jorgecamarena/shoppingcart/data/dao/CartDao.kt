package com.jorgecamarena.shoppingcart.data.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jorgecamarena.shoppingcart.data.entity.CartEntity

@Dao
interface CartDao {

    @Query("SELECT * FROM carts")
    fun getAllCarts(): LiveData<List<CartEntity>>

    @Query("SELECT * FROM carts ORDER BY created_at DESC")
    fun getAllDesc(): LiveData<List<CartEntity>>

    @Query("SELECT * FROM carts ORDER BY created_at DESC LIMIT :limit")
    fun getLastCarts(limit: Int): LiveData<List<CartEntity>>

    @Insert
    fun insert(cartEntity: CartEntity)

    @Insert
    suspend fun insertAll(vararg cartEntities: CartEntity)

    @Delete
    fun delete(cartEntity: CartEntity)

}