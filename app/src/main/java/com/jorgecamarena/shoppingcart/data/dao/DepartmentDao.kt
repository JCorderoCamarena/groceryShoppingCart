package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Department

@Dao
interface DepartmentDao {

    @Query("SELECT * FROM departments ORDER BY department_name ASC")
    fun selectAllDepartmentByNameAsc(): LiveData<List<Department>>

    @Query("SELECT * FROM departments WHERE id=:id")
    fun getDepartmentById(id: Long): LiveData<Department>?

    @Insert
    suspend fun insertDepartment(department: Department)

    @Update
    suspend fun updateDepartment(department: Department)

    @Delete
    suspend fun deleteDepartment(department: Department)

}