package com.weather.myapp.di.networkmodule

import com.weather.myapp.generateWeatherDto
import com.weather.myapp.data.request.CurrentWeatherRequest
import com.weather.myapp.data.response.CurrentLocationResponse
import com.weather.myapp.resource.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeApiHelper: ApiHelper {
    var weatherdto = generateWeatherDto()
    override fun getCurrentWeather(currentWeatherRequest: CurrentWeatherRequest): Flow<Resource<CurrentLocationResponse>> {
        return flowOf(Resource.Success(weatherdto))
    }
}