package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "status",
    indices = [
        Index(value = ["status_name", "status_type"], unique = true)
    ]
)
data class Status(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "status_name") val name: String?,
    @ColumnInfo(name = "status_type") val type: Int?,
    @ColumnInfo(name = "created_at") val createdAt: Long? = 0L,
    @ColumnInfo(name = "modified_at") val modifiedAt: Long? = 0L
)
