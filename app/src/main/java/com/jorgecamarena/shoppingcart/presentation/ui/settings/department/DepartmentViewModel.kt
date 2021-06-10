package com.jorgecamarena.shoppingcart.presentation.ui.settings.department

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jorgecamarena.shoppingcart.data.entity.Department
import com.jorgecamarena.shoppingcart.data.repository.DepartmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DepartmentViewModel @Inject constructor(
    private val departmentRepository: DepartmentRepository
): ViewModel() {

    var departmentList: LiveData<List<Department>> = MutableLiveData()

    var isLoading by mutableStateOf(false)

    var departmentSelected: LiveData<Department> = MutableLiveData()

    init {
        viewModelScope.launch {
            isLoading = true
            departmentRepository.getDepartmentsByNameAsc().let {
                departmentList = it
                isLoading = false
            }
        }
    }

    fun getDepartmentById(id: Long) {
        viewModelScope.launch {
            departmentRepository.getDepartmentById(id)?.let {
                departmentSelected = it
            }
        }
    }

    fun saveDepartment(department: Department) {
        viewModelScope.launch {
            departmentRepository.insertDepartment(department)
        }
    }

    fun updateDepartment(department: Department) {
        viewModelScope.launch {
            departmentRepository.updateDepartment(department)
        }
    }

    fun deleteDepartment(department: Department) {
        viewModelScope.launch {
            departmentRepository.deleteDepartment(department)
        }
    }

}