package com.chapuis.weatherforecastapp.data.model

import com.google.gson.annotations.SerializedName

data class WeatherEntity(
    @SerializedName("daily") val daily: DailyEntity
)

data class DailyEntity(
    @SerializedName("data") val dailyData: List<DailyInfoEntity>
)

data class DailyInfoEntity(
    @SerializedName("humidity") val humidity: Double,
    @SerializedName("icon") val icon: String,
    @SerializedName("pressure") val pressure: Double,
    @SerializedName("summary") val summary: String,
    @SerializedName("temperatureMax") val temperatureMax: Double,
    @SerializedName("temperatureMin") val temperatureMin: Double,
    @SerializedName("time") val time: Int,
    @SerializedName("windSpeed") val windSpeed: Double
)