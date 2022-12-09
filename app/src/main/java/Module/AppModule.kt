package Module

import Application.ApplicationClass
import Database.FoodDatabase
import Repository.FoodRepository
import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun toApp (@ApplicationContext app:Context): ApplicationClass{

        return app as ApplicationClass
    }


    @Volatile
    private var INSTANCE: FoodDatabase? = null

    @Singleton
    @Provides
    fun getDatabase(app: Application): FoodDatabase{

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



    @Singleton
    @Provides
    fun provideRepository (database: FoodDatabase) : FoodRepository
    {
        return FoodRepository(database)

    }

}