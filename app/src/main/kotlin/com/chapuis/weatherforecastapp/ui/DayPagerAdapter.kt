package com.chapuis.weatherforecastapp.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.chapuis.weatherforecastapp.presentation.model.WeatherUiModel
import com.chapuis.weatherforecastapp.ui.day.DayWeatherFragment

class DayPagerAdapter(
    activity: FragmentActivity,
    private val dayWeatherList: List<WeatherUiModel>
) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = dayWeatherList.size

    override fun createFragment(position: Int): Fragment =
        DayWeatherFragment.newInstance(dayWeatherList[position])
}