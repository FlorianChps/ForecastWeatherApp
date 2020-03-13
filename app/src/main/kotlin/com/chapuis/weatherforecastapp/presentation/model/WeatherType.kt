package com.chapuis.weatherforecastapp.presentation.model

import com.chapuis.weatherforecastapp.R

enum class WeatherType(val lottieRes: Int) {
    RAIN(R.raw.rainy_anim),
    SUNNY(R.raw.sun_anim),
    FOGGY(R.raw.foggy_anim),
    PARTY_CLOUDY_DAY(R.raw.party_cloudy_day),
    PARTY_CLOUDY_NIGHT(R.raw.party_cloudy_night),
    SLEET(R.raw.sleet_anim),
    SNOWY(R.raw.snowy_anim),
    WIND(R.raw.wind_anim),
    CLOUDY(R.raw.cloudy_anim),
    CLEAR_NIGHT(R.raw.clear_night_anim)
}