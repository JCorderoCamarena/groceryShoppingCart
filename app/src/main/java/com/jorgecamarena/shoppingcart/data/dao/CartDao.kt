package com.jorgecamarena.shoppingcart.data.dao


import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jorgecamarena.shoppingcart.data.entity.Cart

@Dao
interface CartDao {

    @Query("SELECT * FROM carts")
    fun getAllCarts(): LiveData<List<Cart>>

    @Query("SELECT * FROM carts ORDER BY created_at DESC")
    fun getAllDesc(): LiveData<List<Cart>>

    @Query("SELECT * FROM carts ORDER BY created_at DESC LIMIT :limit")
    fun getLastCarts(limit: Int): LiveData<List<Cart>>

    @Insert
    fun insert(cart: Cart)

    @Insert
    suspend fun insertAll(vararg carts: Cart)

    @Delete
    fun delete(cart: Cart)

}