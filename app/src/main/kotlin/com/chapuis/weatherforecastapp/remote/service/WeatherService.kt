package com.chapuis.weatherforecastapp.remote.service

import com.chapuis.weatherforecastapp.data.model.WeatherEntity
import io.reactivex.Single
import retrofit2.http.GET

interface WeatherService {

    /**
     * Get the weather for location Europe / Paris (this value is hardcoded)
     *
     */
    @GET("forecast/3b5972df2d8884ee63682ff277a108d5/43.2965,5.3698?lang=fr&units=auto")
    fun getWeather(): Single<WeatherEntity>
}