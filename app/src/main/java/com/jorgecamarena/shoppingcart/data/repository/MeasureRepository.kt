package com.jorgecamarena.shoppingcart.data.repository

import androidx.lifecycle.LiveData
import com.jorgecamarena.shoppingcart.data.dao.MeasureDao
import com.jorgecamarena.shoppingcart.data.entity.Measure
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MeasureRepository @Inject constructor(
    val measureDao: MeasureDao
){

    fun getMeasures(): LiveData<List<Measure>> = measureDao.selectMeasuresByNameAsc()

    fun getMeasureById(id: Long): LiveData<Measure>? = measureDao.selectMeasureById(id)

    suspend fun saveMeasure(measure: Measure) {
        measureDao.insertMeasure(
            measure.apply {
                createdAt = System.currentTimeMillis()
                modifiedAt = System.currentTimeMillis()
            }
        )
    }

    suspend fun deleteMeasure(measure: Measure) = measureDao.deleteMeasure(measure)

    suspend fun updateMeasure(measure: Measure) {
        measureDao.updateMeasure(
            measure.apply {
                modifiedAt = System.currentTimeMillis()
            }
        )
    }

}