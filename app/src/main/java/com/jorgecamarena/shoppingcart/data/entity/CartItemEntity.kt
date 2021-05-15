package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(
    tableName = "cart_items",
//    foreignKeys = [
//        ForeignKey(entity = Cart::class, parentColumns = arrayOf("id"), childColumns = arrayOf("cart_id"), onDelete = CASCADE),
//        ForeignKey(entity = Product::class, parentColumns = arrayOf("id"), childColumns = arrayOf("product_id"), onDelete = CASCADE),
//        ForeignKey(entity = ProductCartDetail::class, parentColumns = arrayOf("id"), childColumns = arrayOf("cart_detail_id"), onDelete = CASCADE)
//    ]
)
data class CartItem(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "cart_id") val cartId: Long,
    @ColumnInfo(name = "product_id") val productId: Long,
    @ColumnInfo(name = "cart_detail_id") val cartDetailId: Long,
    @ColumnInfo val status: Int,
    @ColumnInfo val quantity: Int,
    @ColumnInfo val duration: Long
)
