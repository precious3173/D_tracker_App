package com.example.dtrackerapp.Application.Module

import com.example.dtrackerapp.Application.Database.FoodDatabase
import com.example.dtrackerapp.Application.Repository.FoodRepository
import com.example.dtrackerapp.Application.Repository.FoodRepositoryList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRepository (database: FoodDatabase): FoodRepository
    {
        return FoodRepositoryList(database)

    }

}