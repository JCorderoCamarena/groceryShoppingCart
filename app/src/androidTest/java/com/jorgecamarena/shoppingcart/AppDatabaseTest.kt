package com.jorgecamarena.shoppingcart

import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jorgecamarena.shoppingcart.data.AppDatabase
import com.jorgecamarena.shoppingcart.data.dao.ProductDao
import com.jorgecamarena.shoppingcart.data.entity.Product
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception
import kotlin.jvm.Throws

@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {
    private lateinit var productDao: ProductDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        productDao = db.productDao()
    }

    @After
    @Throws(IOException::class)
    fun deleteDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetProduct() = runBlocking {
        val product = Product(
            name = "Test",
            measurement = 1,
            imageLink = "http://test.com/test.jpg",
            createdAt = System.currentTimeMillis()
        )

        productDao.saveProduct(product)
        val firstProduct = productDao.getProductById(1)
        assertEquals(firstProduct?.id, 1L)
    }


}