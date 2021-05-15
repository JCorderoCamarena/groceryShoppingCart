package com.jorgecamarena.shoppingcart.data.repository

import com.jorgecamarena.shoppingcart.data.dao.CartDao
import com.jorgecamarena.shoppingcart.data.entity.Cart
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CartRepository @Inject constructor(
    private val cartDao: CartDao
) {

    fun saveCart(cart: Cart) = cartDao.insert(cart)

    suspend fun getAllCarts() = cartDao.getAllCarts()

    suspend fun getAllCartsInDescOrder() = cartDao.getAllDesc()

    suspend fun getLastCarts(limit: Int) = cartDao.getLastCarts(limit)

    fun deleteCart(cart: Cart) = cartDao.delete(cart)

}
