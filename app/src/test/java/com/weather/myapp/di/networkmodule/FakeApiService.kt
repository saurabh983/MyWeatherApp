package com.weather.myapp.di.networkmodule

import com.weather.myapp.data.response.CurrentLocationResponse
import kotlinx.coroutines.flow.Flow

class FakeApiService: ApiService {

    private var currentLocationResponse: CurrentLocationResponse? = null
    private var flowLocationResponse: Flow<CurrentLocationResponse>? = null

    override suspend fun getCurrentWeatherData(
        key: String,
        lat: Double,
        lon: Double
    ): CurrentLocationResponse {
        return currentLocationResponse!!
    }

    fun initResponse(weatherListDto: CurrentLocationResponse) {
        this.currentLocationResponse = weatherListDto
    }


    fun initResponse(weatherListDto: Flow<CurrentLocationResponse>) {
        this.flowLocationResponse = weatherListDto
    }


}