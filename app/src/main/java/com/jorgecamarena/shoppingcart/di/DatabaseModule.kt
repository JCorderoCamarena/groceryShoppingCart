package com.jorgecamarena.shoppingcart.di

import android.content.Context
import com.jorgecamarena.shoppingcart.data.AppDatabase
import com.jorgecamarena.shoppingcart.data.dao.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context = context)
    }

    @Provides
    fun provideCartDao(appDatabase: AppDatabase): CartDao {
        return appDatabase.cartDao()
    }

    @Provides
    fun provideCartItemDao(appDatabase: AppDatabase): CartItemDao {
        return appDatabase.cartItemDao()
    }

    @Provides
    fun provideDepartmentDao(appDatabase: AppDatabase): DepartmentDao {
        return appDatabase.departmentDao()
    }

    @Provides
    fun provideMeasureDao(appDatabase: AppDatabase): MeasureDao {
        return appDatabase.measureDao()
    }

    @Provides
    fun provideProductCartDetailDao(appDatabase: AppDatabase): ProductCartDetailDao {
        return appDatabase.productCartDetailDao()
    }

    @Provides
    fun provideProductDao(appDatabase: AppDatabase): ProductDao {
        return appDatabase.productDao()
    }

    @Provides
    fun provideStatusDao(appDatabase: AppDatabase): StatusDao {
        return appDatabase.statusDao()
    }
}