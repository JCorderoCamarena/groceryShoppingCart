package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Measure

@Dao
interface MeasureDao {

    @Query("SELECT * FROM measures ORDER BY measure_name ASC")
    fun selectMeasuresByNameAsc(): LiveData<List<Measure>>

    @Query("SELECT * FROM measures WHERE id=:id")
    fun selectMeasureById(id: Long): LiveData<Measure>?

    @Insert
    suspend fun insertMeasure(measure: Measure)

    @Update
    suspend fun updateMeasure(measure: Measure)

    @Delete
    suspend fun deleteMeasure(measure: Measure)

}