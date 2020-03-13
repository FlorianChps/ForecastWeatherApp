package com.chapuis.weatherforecastapp.data

import com.chapuis.weatherforecastapp.domain.mapper.WeatherEntityMapper
import com.chapuis.weatherforecastapp.domain.model.Weather
import com.chapuis.weatherforecastapp.domain.repository.WeatherRepository
import io.reactivex.Single
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val remoteStore: WeatherRemoteStore,
    private val mapper: WeatherEntityMapper
) : WeatherRepository {

    override fun getWeather(): Single<List<Weather>> {
        return remoteStore.getWeather().map { mapper.mapEntityToWeather(it) }
    }
}