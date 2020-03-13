package com.chapuis.weatherforecastapp.remote

import com.chapuis.weatherforecastapp.data.WeatherRemoteStore
import com.chapuis.weatherforecastapp.data.model.WeatherEntity
import com.chapuis.weatherforecastapp.remote.service.WeatherService
import io.reactivex.Single
import javax.inject.Inject

class WeatherDataRemoteStoreImpl @Inject constructor(
    private val service: WeatherService
) : WeatherRemoteStore {

    override fun getWeather(): Single<WeatherEntity> = service.getWeather()
}