package com.chapuis.weatherforecastapp.domain.interactor

import com.chapuis.weatherforecastapp.domain.model.Weather
import com.chapuis.weatherforecastapp.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherInteractorImpl @Inject constructor(
    private val weatherRepository: WeatherRepository
) : WeatherInteractor {

    override fun getWeather(): Single<List<Weather>> = weatherRepository.getWeather()
}