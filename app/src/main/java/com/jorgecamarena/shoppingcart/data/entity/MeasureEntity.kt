package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measures")
data class Measure(
    @PrimaryKey(autoGenerate = true) val id: Long,
    @ColumnInfo(name = "measure_name") val name: String,
    @ColumnInfo(name = "created_at") val createdAt: Long,
    @ColumnInfo(name = "modified_at") val modifiedAt: Long
)
