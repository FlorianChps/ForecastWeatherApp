package com.chapuis.weatherforecastapp.local.di

import android.content.Context
import androidx.room.Room
import com.chapuis.weatherforecastapp.local.dao.WeatherDao
import com.chapuis.weatherforecastapp.local.db.WeatherDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherLocalModule(val context: Context) {

    private val dbName = "weather.db"

    @Singleton
    @Provides
    fun provideDatabase(): WeatherDatabase {
        return Room.databaseBuilder(
            context,
            WeatherDatabase::class.java,
            dbName
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideDatabaseName() = dbName

    @Singleton
    @Provides
    fun provideWeatherDao(weatherDb: WeatherDatabase): WeatherDao = weatherDb.weatherDao()
}