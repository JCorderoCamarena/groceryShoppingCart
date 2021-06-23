package com.jorgecamarena.shoppingcart.data.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "product_name") var name: String = "",
    @ColumnInfo(name = "measurement") val measurement: Long? = null,
    @ColumnInfo(name = "image_link") var imageLink: String = "",
    @ColumnInfo(name = "created_at") var createdAt: Long? = null,
    @ColumnInfo(name = "modified_at") var modifiedAt: Long? = null
)