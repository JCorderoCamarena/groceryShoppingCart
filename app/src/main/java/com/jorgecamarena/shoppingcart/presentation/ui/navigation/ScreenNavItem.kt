package com.jorgecamarena.shoppingcart.presentation.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DeviceUnknown
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.presentation.ui.NavigationRoutes
import com.jorgecamarena.shoppingcart.presentation.ui.Routes
import kotlin.reflect.jvm.internal.impl.descriptors.Visibilities

sealed class ScreenNavItem(
    val item: Routes,
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector,
    val isPartOfBottomBar: Boolean? = false,
    val parentRoute: Routes? = null
) {
    object Home: ScreenNavItem(Routes.Home, NavigationRoutes.Home, R.string.title_home, Icons.Filled.Home, true)
    object Settings: ScreenNavItem(Routes.Settings, NavigationRoutes.Settings, R.string.title_settings, Icons.Filled.Settings, true)
    object About: ScreenNavItem(Routes.About, NavigationRoutes.About, R.string.title_about, Icons.Filled.Info, true)

    object ProductList: ScreenNavItem(Routes.ProductList, NavigationRoutes.ProductList, R.string.title_products, Icons.Filled.Info, false, Routes.Settings)
    object ProductAdd: ScreenNavItem(Routes.ProductAdd, NavigationRoutes.AddProduct, R.string.title_add_product, Icons.Filled.Info, false, Routes.Settings)
    object ProductEdit: ScreenNavItem(Routes.ProductEdit, NavigationRoutes.EditProduct, R.string.title_edit_product, Icons.Filled.Info, false, Routes.Settings)

    object DepartmentList: ScreenNavItem(Routes.DepartmentList, NavigationRoutes.DepartmentList, R.string.title_departments, Icons.Filled.Info, false, Routes.Settings)
    object DepartmentAdd: ScreenNavItem(Routes.DepartmentAdd, NavigationRoutes.AddDepartment, R.string.title_add_department, Icons.Filled.Info, false, Routes.Settings)
    object DepartmentEdit: ScreenNavItem(Routes.DepartmentEdit, NavigationRoutes.EditDepartment, R.string.title_edit_department, Icons.Filled.Info, false, Routes.Settings)

    object MeasureList: ScreenNavItem(Routes.MeasuresList, NavigationRoutes.MeasureList, R.string.title_measures, Icons.Filled.Info, false, Routes.Settings)
    object MeasureAdd: ScreenNavItem(Routes.MeasuresAdd, NavigationRoutes.AddMeasure, R.string.title_add_measure, Icons.Filled.Info, false, Routes.Settings)
    object MeasureEdit: ScreenNavItem(Routes.MeasuresEdit, NavigationRoutes.EditMeasure, R.string.title_edit_measure, Icons.Filled.Info, false, Routes.Settings)

    object StatusList: ScreenNavItem(Routes.StatusList, NavigationRoutes.StatusList, R.string.title_status, Icons.Filled.Info, false, Routes.Settings)
    object StatusAdd: ScreenNavItem(Routes.StatusAdd, NavigationRoutes.AddStatus, R.string.title_add_status, Icons.Filled.Info, false, Routes.Settings)
    object StatusEdit: ScreenNavItem(Routes.StatusEdit, NavigationRoutes.EditStatus, R.string.title_edit_status, Icons.Filled.Info, false, Routes.Settings)

    object Unknown: ScreenNavItem(Routes.Unknown, "", -1, Icons.Filled.DeviceUnknown )

    companion object {

        fun fromScreenNavString(possibleRoute: String): ScreenNavItem {
            return ScreenNavItem::class.sealedSubclasses
                .firstOrNull { it.objectInstance?.route == possibleRoute }
                ?.objectInstance
                ?: Unknown
        }

    }

}
