package com.example.shoppinglist.presentation.di

import com.example.shoppinglist.data.ShopListRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(): ShopListRepoImpl = ShopListRepoImpl()
}