package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Status

@Dao
interface StatusDao {

    @Query("SELECT * FROM status ORDER BY status_name ASC")
    fun selectStatusByNameAsc(): LiveData<List<Status>>

    @Query("SELECT * FROM status WHERE id=:statusId")
    fun selectStatus(statusId: Long): Status

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStatus(status: Status)

    @Update
    suspend fun updateStatus(status: Status)

    @Delete
    suspend fun deleteStatus(status: Status)

}