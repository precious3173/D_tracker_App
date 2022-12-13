package com.example.dtrackerapp.Application.Module

import com.example.dtrackerapp.Application.Database.FoodDatabase
import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {


    @Volatile
    private var INSTANCE: FoodDatabase? = null

    @Singleton
    @Provides
    fun getDatabase(app: Application): FoodDatabase {

        val instance = INSTANCE

        if(instance != null) return instance


        synchronized(this){

            val instanceofDatabase = Room.databaseBuilder(app.applicationContext,
                FoodDatabase::class.java,
                "Food_Database").allowMainThreadQueries().build()

            INSTANCE = instanceofDatabase

            return instanceofDatabase
        }
    }

}