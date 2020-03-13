package com.chapuis.weatherforecastapp.local

import com.chapuis.weatherforecastapp.domain.model.Weather
import com.chapuis.weatherforecastapp.local.dao.WeatherDao
import com.chapuis.weatherforecastapp.local.mapper.WeatherTableMapper
import io.reactivex.Maybe
import javax.inject.Inject

class WeatherDataLocalStoreImpl @Inject constructor(
    private val weatherDao: WeatherDao,
    private val mapper: WeatherTableMapper
) : WeatherLocalStore {

    override fun saveWeather(weather: Weather) {
        weatherDao.save(mapper.mapToWeatherTableList(weather))
    }

    override fun getWeather(): Maybe<List<Weather>> {
        return Maybe.fromCallable { mapper.mapToWeatherEntityList(weatherDao.getAll()) }
    }

}