package com.jorgecamarena.shoppingcart.presentation.ui.settings.department

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jorgecamarena.shoppingcart.presentation.ui.theme.ShoppingCartTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Department

@Composable
fun AddDepartmentScreen(
    departmentViewModel: DepartmentViewModel,
    navHostController: NavHostController
) {
    DepartmentScreenForm(
        onSaveDepartment = departmentViewModel::saveDepartment,
        onGoBackToList = navHostController::navigateUp,
        department = Department()
    )
}


@Composable
fun DepartmentScreenForm(
    onSaveDepartment: (Department) -> Unit,
    onGoBackToList: () -> Unit,
    department: Department,
    name: String = ""
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        var departmentName by remember { mutableStateOf(name) }
        
        OutlinedTextField(
            value = departmentName,
            onValueChange = { departmentName = it },
            label = { Text(text = stringResource(id = R.string.label_department_name)) }
        )
        
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(0.8f),
            horizontalArrangement = Arrangement.Center
        ) {

            Button(
                modifier = Modifier.fillMaxWidth(0.6f),
                onClick = {
                    onSaveDepartment(
                        department.apply {
                            this.name = departmentName
                        }
                    )
                    onGoBackToList()
                },
                enabled = departmentName.isNotBlank()
            ) {
                Text(text = stringResource(id = R.string.label_save))
            }
        }
    }
}

@Preview
@Composable
fun AddDepartmentScreenPreview() {
    ShoppingCartTheme {
        DepartmentScreenForm(
            onSaveDepartment = {  },
            onGoBackToList = {  },
            department = Department()
        )
    }
}