package com.chapuis.weatherforecastapp.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.chapuis.weatherforecastapp.local.table.DayWeatherTable

@Dao
interface WeatherDao {

    @Insert(onConflict = REPLACE)
    fun save(dayWeatherTable: DayWeatherTable)

    @Query("SELECT * FROM weather")
    fun getAll(): List<DayWeatherTable>
}