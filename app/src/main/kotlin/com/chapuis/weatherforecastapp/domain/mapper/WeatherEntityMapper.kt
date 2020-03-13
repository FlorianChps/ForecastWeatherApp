package com.chapuis.weatherforecastapp.domain.mapper

import com.chapuis.weatherforecastapp.data.model.DailyInfoEntity
import com.chapuis.weatherforecastapp.data.model.WeatherEntity
import com.chapuis.weatherforecastapp.domain.model.Weather
import javax.inject.Inject

class WeatherEntityMapper @Inject constructor() {

    fun mapEntityToWeather(entityWeather: WeatherEntity): List<Weather> {
        return entityWeather.daily.dailyData.map(::mapToWeather)
    }

    private fun mapToWeather(dailyInfoEntity: DailyInfoEntity): Weather {
        return Weather(
            dailyInfoEntity.humidity,
            dailyInfoEntity.icon,
            dailyInfoEntity.pressure,
            dailyInfoEntity.summary,
            dailyInfoEntity.temperatureMax,
            dailyInfoEntity.temperatureMin,
            dailyInfoEntity.time,
            dailyInfoEntity.windSpeed
        )
    }
}