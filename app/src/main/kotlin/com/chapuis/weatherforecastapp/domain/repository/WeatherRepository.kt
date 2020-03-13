package com.chapuis.weatherforecastapp.domain.repository

import com.chapuis.weatherforecastapp.domain.model.Weather
import io.reactivex.Single

interface WeatherRepository {

    fun getWeather(): Single<List<Weather>>
}