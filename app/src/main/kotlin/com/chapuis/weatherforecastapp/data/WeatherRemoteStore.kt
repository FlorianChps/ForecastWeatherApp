package com.chapuis.weatherforecastapp.data

import com.chapuis.weatherforecastapp.data.model.WeatherEntity
import io.reactivex.Single

interface WeatherRemoteStore {

    fun getWeather(): Single<WeatherEntity>
}