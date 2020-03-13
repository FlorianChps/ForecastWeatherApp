package com.chapuis.weatherforecastapp.presentation.mapper

import com.chapuis.weatherforecastapp.domain.model.Weather
import com.chapuis.weatherforecastapp.presentation.model.WeatherType
import com.chapuis.weatherforecastapp.presentation.model.WeatherUiModel
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun mapModelToUiModel(weather: List<Weather>): List<WeatherUiModel> {
        return weather.map(::mapWeatherToUiModel)
    }

    private fun mapWeatherToUiModel(weather: Weather): WeatherUiModel {
        return WeatherUiModel(
            weather.humidity,
            mapIconToType(weather.icon),
            weather.pressure,
            weather.summary,
            weather.temperatureMax,
            weather.temperatureMin,
            weather.time,
            weather.windSpeed
        )
    }

    private fun mapIconToType(icon: String): WeatherType {
        return when (icon) {
            "cloudy" -> WeatherType.CLOUDY
            "clear-night" -> WeatherType.CLEAR_NIGHT
            "sleet" -> WeatherType.SLEET
            "clear-day" -> WeatherType.SUNNY
            "partly-cloudy-night" -> WeatherType.PARTY_CLOUDY_NIGHT
            "partly-cloudy-day" -> WeatherType.PARTY_CLOUDY_DAY
            "snow" -> WeatherType.SNOWY
            "fog" -> WeatherType.FOGGY
            "wind" -> WeatherType.WIND
            "rain" -> WeatherType.RAIN
            else -> throw IllegalArgumentException("This $icon value does not match with a type")
        }
    }
}