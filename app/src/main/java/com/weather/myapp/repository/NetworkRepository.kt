package com.weather.myapp.repository

import com.weather.myapp.data.request.CurrentWeatherRequest
import com.weather.myapp.di.networkmodule.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NetworkRepository @Inject constructor(val apiHelper: ApiHelper) {
    fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest) = apiHelper.getCurrentWeather(currentWeatherRequest).flowOn(Dispatchers.IO)
}