package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measures")
data class Measure(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "measure_name") var name: String = "",
    @ColumnInfo(name = "created_at") var createdAt: Long? = null,
    @ColumnInfo(name = "modified_at") var modifiedAt: Long? = null
)
