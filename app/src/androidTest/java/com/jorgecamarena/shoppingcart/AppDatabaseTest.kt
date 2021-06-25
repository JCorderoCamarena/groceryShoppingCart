package com.jorgecamarena.shoppingcart

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.jorgecamarena.shoppingcart.data.AppDatabase
import com.jorgecamarena.shoppingcart.data.dao.MeasureDao
import com.jorgecamarena.shoppingcart.data.dao.ProductDao
import com.jorgecamarena.shoppingcart.data.dao.StatusDao
import com.jorgecamarena.shoppingcart.data.entity.Product
import com.jorgecamarena.shoppingcart.data.entity.Status
import com.jorgecamarena.shoppingcart.utils.MeasuresUtil
import com.jorgecamarena.shoppingcart.utils.StatusUtil
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException
import java.lang.Exception
import kotlin.jvm.Throws


@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AppDatabaseTest {

    @get: Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var productDao: ProductDao
    private lateinit var statusDao: StatusDao
    private lateinit var measureDao: MeasureDao

    private lateinit var db: AppDatabase


    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext

        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java)
            .allowMainThreadQueries()
            .build()

        productDao = db.productDao()
        statusDao = db.statusDao()
        measureDao = db.measureDao()
    }

    @After
    @Throws(IOException::class)
    fun teardown() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun insertAndGetProduct() = runBlockingTest {
        val product = Product(
            name = "Test",
            measurement = 1,
            imageLink = "http://test.com/test.jpg",
            createdAt = System.currentTimeMillis()
        )

        productDao.saveProduct(product)
        val firstProduct = productDao.getProductById(1)?.getOrAwaitValue(time = 5)
        assertEquals(firstProduct?.id, 1L)
    }

    @Test
    @Throws(Exception::class)
    fun insertStatusAvoidRepeated() = runBlockingTest {
        val statusList: List<Status> = StatusUtil.buildListOfStatus()

        statusList.forEach {
            statusDao.insertStatus(it)
        }

        statusList.forEach {
            statusDao.insertStatus(it)
        }

        val listFromDatabase = statusDao.selectStatusByNameAsc().getOrAwaitValue(time = 5)

        assertEquals(listFromDatabase.size, statusList.size)
    }

    @Test
    fun insertMeasureAvoidDuplicates() = runBlockingTest {
        val measureListToInsert = MeasuresUtil.buildListOfMeasures()

        measureListToInsert.forEach {
            measureDao.insertMeasure(it)
        }

        measureListToInsert.forEach {
            measureDao.insertMeasure(it)
        }

        val measuresInDatabase = measureDao.selectMeasuresByNameAsc().getOrAwaitValue(time = 5)

        assertEquals(measuresInDatabase.size, measureListToInsert.size)
    }



}