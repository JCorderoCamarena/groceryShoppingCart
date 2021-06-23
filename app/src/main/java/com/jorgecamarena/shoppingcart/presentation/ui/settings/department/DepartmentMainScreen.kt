package com.jorgecamarena.shoppingcart.presentation.ui.settings.department

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams
import com.jorgecamarena.shoppingcart.presentation.ui.settings.department.list.DepartmentList

@ExperimentalMaterialApi
@Composable
fun DepartmentMainScreen(
    departmentViewModel: DepartmentViewModel,
    navHostController: NavHostController
) {
    val departmentList = departmentViewModel.departmentList.observeAsState(listOf()).value

    if (departmentList.isNotEmpty()) {
        DepartmentList(
            departmentList = departmentList,
            onDeleteDepartment = departmentViewModel::deleteDepartment,
            onEditDepartment = { id ->
                id?.let {
                    navHostController.navigate(RoutesWithParams.getEditDepartmentRoute("$it"))
                }
            }
        )
    } else {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = stringResource(id = R.string.label_no_departments_found))
        }
    }
}