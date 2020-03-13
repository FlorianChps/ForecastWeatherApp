package com.chapuis.weatherforecastapp.presentation.viewmodel.state

import com.chapuis.weatherforecastapp.presentation.model.WeatherUiModel

sealed class WeatherState {

    object Loading : WeatherState()

    data class Success(
        val weather: List<WeatherUiModel>
    ) : WeatherState()

    data class Error(
        val error: Throwable
    ) : WeatherState()
}