package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.ProductCartDetail

@Dao
interface ProductCartDetailDao {

    @Query("SELECT * FROM product_cart_details WHERE id=:cartDetailId")
    fun getProductCartDetail(cartDetailId: Int): LiveData<ProductCartDetail>?

    @Insert
    fun insertProductCartDetail(productCartDetail: ProductCartDetail)

    @Update
    fun updateProductCartDetail(productCartDetail: ProductCartDetail)

    @Delete
    fun deleteProductCartDetail(productCartDetail: ProductCartDetail)
}