package com.chapuis.weatherforecastapp.local.mapper

import com.chapuis.weatherforecastapp.data.model.DailyInfoEntity
import com.chapuis.weatherforecastapp.domain.model.Weather
import com.chapuis.weatherforecastapp.local.table.DayWeatherTable
import javax.inject.Inject

class WeatherTableMapper @Inject constructor() {

    fun mapToWeatherTableList(weather: Weather): DayWeatherTable {
        return DayWeatherTable(
            weather.time,
            weather.humidity,
            weather.icon,
            weather.pressure,
            weather.summary,
            weather.temperatureMax,
            weather.temperatureMin,
            weather.windSpeed
        )
    }

    private fun mapToTableWeather(dailyEntity: DailyInfoEntity): DayWeatherTable {
        return DayWeatherTable(
            dailyEntity.time,
            dailyEntity.humidity,
            dailyEntity.icon,
            dailyEntity.pressure,
            dailyEntity.summary,
            dailyEntity.temperatureMax,
            dailyEntity.temperatureMin,
            dailyEntity.windSpeed
        )
    }

    fun mapToWeatherEntityList(list: List<DayWeatherTable>): List<Weather>? {
        return list.map(::mapTableToWeather)
    }

    private fun mapTableToWeather(dayWeatherTable: DayWeatherTable): Weather {
        return Weather(
            dayWeatherTable.humidity,
            dayWeatherTable.icon,
            dayWeatherTable.pressure,
            dayWeatherTable.summary,
            dayWeatherTable.temperatureMax,
            dayWeatherTable.temperatureMin,
            dayWeatherTable.time,
            dayWeatherTable.windSpeed
        )
    }
}