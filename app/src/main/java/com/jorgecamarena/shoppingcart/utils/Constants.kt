package com.jorgecamarena.shoppingcart.utils

import android.util.Log
import androidx.annotation.StringRes
import com.jorgecamarena.shoppingcart.R
import com.jorgecamarena.shoppingcart.data.entity.Measure
import com.jorgecamarena.shoppingcart.data.entity.Status

const val DATABASE_NAME = "shopping-cart-db"

enum class MeasureEnum(
    val type: Int,
    val measureName: String,
    @StringRes val singleName: Int,
    @StringRes val pluralName: Int
) {
    Kilogram(1, "Kilogram",R.string.measure_kilogram, R.plurals.kilogram),
    Liter(2, "Liter", R.string.measure_liter, R.plurals.liter),
    Piece(3, "Piece", R.string.measure_piece, R.plurals.piece),
    Gallon(4, "Gallon", R.string.measure_gallon, R.plurals.gallon),
    Meter(5, "Meter", R.string.measure_meter, R.plurals.meter),
    Foot(6, "Foot", R.string.measure_foot, R.plurals.foot)
}

enum class StatusEnum(
    val type: Int,
    @StringRes val resourceName: Int
) {
    Pending(1, R.string.status_pending),
    NotFound(2, R.string.status_not_found),
    AddedToCart(3, R.string.status_added_to_cart)
}

object MeasuresUtil {
    fun buildListOfMeasures(): List<Measure> {
        return enumValues<MeasureEnum>().map {
            Log.d("DEBUG", "buildListOfMeasures: ${it.singleName} ${it.pluralName}")
            Measure(name = it.measureName, type = it.type)
        }
    }

    fun fromType(type: Int): MeasureEnum? = MeasureEnum.values().find { it.type == type }
}

object StatusUtil {
    fun buildListOfStatus(): List<Status> {
        return enumValues<StatusEnum>().map {
            Log.d("DEBUG", "buildListOfStatus: ${it.resourceName}")
            Status(name = it.name, type = it.type)
        }
    }
}