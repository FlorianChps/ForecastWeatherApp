package com.chapuis.weatherforecastapp.domain.interactor

import com.chapuis.weatherforecastapp.domain.model.Weather
import io.reactivex.Single

interface WeatherInteractor {

    fun getWeather(): Single<List<Weather>>
}