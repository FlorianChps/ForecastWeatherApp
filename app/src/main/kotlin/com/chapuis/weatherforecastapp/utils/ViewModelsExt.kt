package com.chapuis.weatherforecastapp.utils

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun <T : ViewModel> FragmentActivity.getViewModel(
    modelClass: Class<T>,
    viewModelFactory: ViewModelProvider.Factory? = null
): T {
    val viewModelProvider = viewModelFactory?.let {
        ViewModelProvider(this, it)
    } ?: ViewModelProvider(this)
    return viewModelProvider.get(modelClass)
}