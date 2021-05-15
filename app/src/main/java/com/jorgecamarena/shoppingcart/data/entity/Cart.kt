package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "carts")
data class Cart(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    @ColumnInfo(name = "created_at") val createdAt: Long?,
    @ColumnInfo(name = "modified_at") val modifiedAt: Long?,
    @ColumnInfo val timezone: String?
//    @ColumnInfo(name = "creator") val creator: Long <--- POSSIBLE FOREIGN KEY
)