package com.jorgecamarena.shoppingcart.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "departments")
data class Department(
    @PrimaryKey(autoGenerate = true) val id: Long? = null,
    @ColumnInfo(name = "department_name") var name: String? = null,
    @ColumnInfo(name = "created_at") var createdAt: Long? = null,
    @ColumnInfo(name = "modified_at") var modifiedAt: Long? = null
)
