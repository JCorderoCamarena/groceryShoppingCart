package com.jorgecamarena.shoppingcart.di

import com.jorgecamarena.shoppingcart.data.dao.MeasureDao
import com.jorgecamarena.shoppingcart.data.dao.ProductDao
import com.jorgecamarena.shoppingcart.data.repository.MeasureRepository
import com.jorgecamarena.shoppingcart.data.repository.ProductRepository
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

}