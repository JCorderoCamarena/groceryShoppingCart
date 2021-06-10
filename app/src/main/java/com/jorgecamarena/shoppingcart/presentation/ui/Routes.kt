package com.jorgecamarena.shoppingcart.presentation.ui

enum class Routes {
    Unknown,

    Home,
    Settings,
    About,

    ProductList,
    ProductAdd,
    ProductEdit,

    DepartmentList,
    DepartmentAdd,
    DepartmentEdit,

    MeasuresList,
    MeasuresAdd,
    MeasuresEdit,

    StatusList,
    StatusAdd,
    StatusEdit,

    CartAdd,
    CartEdit,
}


object NavigationRoutes {

    const val Home              = "Home"
    const val Settings          = "Settings"
    const val About             = "About"

    const val ProductList       = "productList"
    const val AddProduct        = "addProduct"
    const val EditProduct       = "editProduct/{productId}"

    const val DepartmentList    = "departmentList"
    const val AddDepartment     = "addDepartment"
    const val EditDepartment    = "editDepartment/{departmentId}"

    const val MeasureList       = "measureList"
    const val AddMeasure        = "addMeasure"
    const val EditMeasure       = "editMeasure/{measureId}"

    const val StatusList        = "statusList"
    const val AddStatus         = "addStatus"
    const val EditStatus        = "editStatus/{statusId}"
}