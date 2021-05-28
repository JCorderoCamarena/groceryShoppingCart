package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Measure

@Dao
interface MeasureDao {

    @Query("SELECT * FROM measures ORDER BY measure_name ASC")
    fun selectMeasuresByNameAsc(): LiveData<List<Measure>>

    @Insert
    fun insertMeasure(measure: Measure)

    @Update
    fun updateMeasure(measure: Measure)

    @Delete
    fun deleteMeasure(measure: Measure)

}