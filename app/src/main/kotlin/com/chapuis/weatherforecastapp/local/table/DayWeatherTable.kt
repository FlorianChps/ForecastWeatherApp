package com.chapuis.weatherforecastapp.local.table

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "weather")
data class DayWeatherTable(
    @PrimaryKey val time: Int,
    val humidity: Double,
    val icon: String,
    val pressure: Double,
    val summary: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val windSpeed: Double
) : Parcelable