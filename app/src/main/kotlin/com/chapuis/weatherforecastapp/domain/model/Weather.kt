package com.chapuis.weatherforecastapp.domain.model

data class Weather(
    val humidity: Double,
    val icon: String,
    val pressure: Double,
    val summary: String,
    val temperatureMax: Double,
    val temperatureMin: Double,
    val time: Int,
    val windSpeed: Double
)