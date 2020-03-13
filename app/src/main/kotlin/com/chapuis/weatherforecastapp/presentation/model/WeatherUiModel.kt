package com.chapuis.weatherforecastapp.presentation.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherUiModel(
    val humidity: Double,
    val type: WeatherType,
    val pressure: Double,
    val summary: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val time: Int,
    val windSpeed: Double
) : Parcelable