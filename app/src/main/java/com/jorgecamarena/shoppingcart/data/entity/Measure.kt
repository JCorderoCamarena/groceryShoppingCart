package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "measures",
    indices = [
        Index(value = ["measure_name","measure_type"], unique = true)
    ]
)
data class Measure(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "measure_name") var name: String = "",
    @ColumnInfo(name = "measure_type") var type: Int? = 0,
    @ColumnInfo(name = "created_at") var createdAt: Long? = null,
    @ColumnInfo(name = "modified_at") var modifiedAt: Long? = null
)
