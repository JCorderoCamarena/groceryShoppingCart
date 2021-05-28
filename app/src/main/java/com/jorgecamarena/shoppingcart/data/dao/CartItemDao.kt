package com.jorgecamarena.shoppingcart.data.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.jorgecamarena.shoppingcart.data.entity.CartItem

@Dao
interface CartItemDao {

    // TODO: Define select method

    @Insert
    fun insertCartItem(cartItem: CartItem)

    @Update
    fun updateCartItem(cartItem: CartItem)

    @Delete
    fun deleteCartItem(cartItem: CartItem)
}