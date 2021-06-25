package com.jorgecamarena.shoppingcart.di

import com.jorgecamarena.shoppingcart.data.dao.DepartmentDao
import com.jorgecamarena.shoppingcart.data.dao.MeasureDao
import com.jorgecamarena.shoppingcart.data.dao.ProductDao
import com.jorgecamarena.shoppingcart.data.dao.StatusDao
import com.jorgecamarena.shoppingcart.data.repository.DepartmentRepository
import com.jorgecamarena.shoppingcart.data.repository.MeasureRepository
import com.jorgecamarena.shoppingcart.data.repository.ProductRepository
import com.jorgecamarena.shoppingcart.data.repository.StatusRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideProductRepository(productDao: ProductDao): ProductRepository {
        return ProductRepository(
            productDao = productDao
        )
    }

    @Singleton
    @Provides
    fun provideMeasureRepository(measureDao: MeasureDao): MeasureRepository {
        return MeasureRepository(
            measureDao = measureDao
        )
    }

    @Singleton
    @Provides
    fun provideDepartmentRepository(departmentDao: DepartmentDao): DepartmentRepository {
        return DepartmentRepository(
            departmentDao = departmentDao
        )
    }

    @Singleton
    @Provides
    fun provideStatusRepository(statusDao: StatusDao): StatusRepository {
        return StatusRepository(
            statusDao = statusDao
        )
    }

 }