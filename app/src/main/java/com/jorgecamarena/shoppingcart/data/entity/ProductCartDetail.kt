package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_cart_details")
data class ProductCartDetail(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "notes") val notes: String?
)
