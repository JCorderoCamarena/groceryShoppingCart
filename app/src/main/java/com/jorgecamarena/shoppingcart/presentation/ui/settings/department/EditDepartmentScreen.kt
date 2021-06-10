package com.jorgecamarena.shoppingcart.presentation.ui.settings.department

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController

@Composable
fun EditDepartmentScreen(
    departmentViewModel: DepartmentViewModel,
    navHostController: NavHostController,
    idDepartment: Long
) {
    val departmentToEdit = departmentViewModel.departmentSelected.observeAsState().value

    departmentViewModel.getDepartmentById(idDepartment)

    departmentToEdit?.name?.let { departmentName ->
        DepartmentScreenForm(
            onSaveDepartment = departmentViewModel::updateDepartment,
            onGoBackToList = navHostController::navigateUp,
            department = departmentToEdit,
            name = departmentName
        )
    }
}