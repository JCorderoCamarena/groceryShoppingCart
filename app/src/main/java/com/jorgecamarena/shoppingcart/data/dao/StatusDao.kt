package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Status

@Dao
interface StatusDao {

    @Query("SELECT * FROM status ORDER BY status_name ASC")
    fun selectStatusByNameAsc(): LiveData<List<Status>>

    @Insert
    fun insertStatus(status: Status)

    @Update
    fun updateStatus(status: Status)

    @Delete
    fun deleteStatus(status: Status)

}