package com.jorgecamarena.shoppingcart.data.repository

import androidx.lifecycle.LiveData
import com.jorgecamarena.shoppingcart.data.dao.DepartmentDao
import com.jorgecamarena.shoppingcart.data.entity.Department
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DepartmentRepository @Inject constructor(
    private val departmentDao: DepartmentDao
) {

    fun getDepartmentsByNameAsc(): LiveData<List<Department>> = departmentDao.selectAllDepartmentByNameAsc()

    suspend fun insertDepartment(department: Department) {
        departmentDao.insertDepartment(
            department.apply {
                createdAt = System.currentTimeMillis()
                modifiedAt = System.currentTimeMillis()
            }
        )
    }

    fun getDepartmentById(id: Long): LiveData<Department>? = departmentDao.getDepartmentById(id)

    suspend fun updateDepartment(department: Department) {
        departmentDao.updateDepartment(
            department.apply {
                modifiedAt = System.currentTimeMillis()
            }
        )
    }

    suspend fun deleteDepartment(department: Department) {
        departmentDao.deleteDepartment(department)
    }

}