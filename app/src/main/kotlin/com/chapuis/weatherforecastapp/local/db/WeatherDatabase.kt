package com.chapuis.weatherforecastapp.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.chapuis.weatherforecastapp.local.dao.WeatherDao
import com.chapuis.weatherforecastapp.local.table.DayWeatherTable

@Database(entities = [DayWeatherTable::class], version = 1)
abstract class WeatherDatabase : RoomDatabase() {

    abstract fun weatherDao(): WeatherDao
}