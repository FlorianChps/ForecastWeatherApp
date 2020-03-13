package com.chapuis.weatherforecastapp.local

import com.chapuis.weatherforecastapp.domain.model.Weather
import io.reactivex.Maybe

interface WeatherLocalStore {

    fun saveWeather(weather: Weather)

    fun getWeather(): Maybe<List<Weather>>
}