package com.jorgecamarena.shoppingcart.data.repository

import androidx.lifecycle.LiveData
import com.jorgecamarena.shoppingcart.data.dao.StatusDao
import com.jorgecamarena.shoppingcart.data.entity.Status
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StatusRepository @Inject constructor(
    private val statusDao: StatusDao
) {

    fun getAllStatusByNameAsc(): LiveData<List<Status>> {
        return statusDao.selectStatusByNameAsc()
    }

    fun getStatus(statusId: Long): Status {
        return statusDao.selectStatus(statusId)
    }

    suspend fun insertStatus(status: Status) {
        statusDao.insertStatus(
            status.copy(
                createdAt = System.currentTimeMillis(),
                modifiedAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun updateStatus(status: Status) {
        statusDao.updateStatus(
            status.copy(
                modifiedAt = System.currentTimeMillis()
            )
        )
    }

    suspend fun deleteStatus(status: Status) {
        statusDao.deleteStatus(status)
    }
}