package com.jorgecamarena.shoppingcart.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.jorgecamarena.shoppingcart.data.entity.Department

@Dao
interface DepartmentDao {

    @Query("SELECT * FROM departments ORDER BY department_name ASC")
    fun selectAllDepartmentByNameAsc(): LiveData<List<Department>>

    @Insert
    fun insertDepartment(department: Department)

    @Update
    fun updateDepartment(department: Department)

    @Delete
    fun deleteDepartment(department: Department)

}