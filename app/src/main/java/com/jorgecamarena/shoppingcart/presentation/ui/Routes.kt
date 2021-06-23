package com.jorgecamarena.shoppingcart.presentation.ui

import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams.getEditCartRoute
import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams.getEditDepartmentRoute
import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams.getEditMeasureRoute
import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams.getEditProductRoute
import com.jorgecamarena.shoppingcart.presentation.ui.RoutesWithParams.getEditStatusRoute
import com.jorgecamarena.shoppingcart.utils.*

enum class Routes(
    val route: String
) {
    Unknown("Unknown"),

    Home("Home"),
    Settings("Settings"),
    About("About"),

    ProductList("productList"),
    ProductAdd("addProduct"),
    ProductEdit(getEditProductRoute()),

    DepartmentList("departmentList"),
    DepartmentAdd("addDepartment"),
    DepartmentEdit(getEditDepartmentRoute()),

    MeasuresList("measureList"),
    MeasuresAdd("addMeasure"),
    MeasuresEdit(getEditMeasureRoute()),

    StatusList("statusList"),
    StatusAdd("addStatus"),
    StatusEdit(getEditStatusRoute()),

    CartAdd("addCart"),
    CartEdit(getEditCartRoute()),
}


object RoutesWithParams {

    fun getEditProductRoute(param: String = "{$PRODUCT_ID}"): String {
        return "editProduct/$param"
    }

    fun getEditDepartmentRoute(param: String = "{$DEPARTMENT_ID}"): String {
        return "editDepartment/$param"
    }

    fun getEditMeasureRoute(param: String = "{$MEASURE_ID}"): String {
        return "editMeasure/$param"
    }

    fun getEditStatusRoute(param: String = "{$STATUS_ID}"): String {
        return "editStatus/$param";
    }

    fun getEditCartRoute(param: String = "{$CART_ID}") : String {
        return "editCart/$param"
    }
}