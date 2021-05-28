package com.jorgecamarena.shoppingcart.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.jorgecamarena.shoppingcart.data.dao.*
import com.jorgecamarena.shoppingcart.data.entity.*
import com.jorgecamarena.shoppingcart.utils.DATABASE_NAME


@Database(
    entities = [
        Cart::class,
        CartItem::class,
        Department::class,
        Measure::class,
        Product::class,
        ProductCartDetail::class,
        Status::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {

    // DAO's
    abstract fun cartDao(): CartDao
    abstract fun cartItemDao(): CartItemDao
    abstract fun departmentDao(): DepartmentDao
    abstract fun measureDao(): MeasureDao
    abstract fun productCartDetailDao(): ProductCartDetailDao
    abstract fun productDao(): ProductDao
    abstract fun statusDao(): StatusDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                //.addCallback()   <- If need to prepopulate database
                .build()
        }
    }

}