package com.weather.myapp.di.networkmodule

import com.weather.myapp.data.request.CurrentWeatherRequest
import com.weather.myapp.data.response.CurrentLocationResponse
import com.weather.myapp.resource.Resource
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>>
}