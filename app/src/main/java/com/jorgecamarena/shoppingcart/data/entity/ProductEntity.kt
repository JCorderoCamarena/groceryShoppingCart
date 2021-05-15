package com.jorgecamarena.shoppingcart.data.entity


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class Product(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "product_name") val name: String,
    @ColumnInfo(name = "measurement") val measurement: Long,
    @ColumnInfo(name = "image_link") val imageLink: String,
    @ColumnInfo(name = "created_at") val createdAt: Long,
    @ColumnInfo(name = "modified_at") val modifiedAt: Long
) {
    constructor() : this(
        id = 0L,
        name = "",
        measurement = 0L,
        imageLink = "",
        createdAt = 0L,
        modifiedAt = 0L
    )
}
