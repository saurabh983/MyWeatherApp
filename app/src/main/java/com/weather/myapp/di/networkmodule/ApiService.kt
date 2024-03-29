package com.weather.myapp.di.networkmodule

import androidx.annotation.Keep
import com.weather.myapp.data.response.CurrentLocationResponse
import retrofit2.http.GET
import retrofit2.http.Query

@Keep
interface ApiService {
    @GET("weather")
    suspend fun getCurrentWeatherData(
        @Query("appid") key: String,
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): CurrentLocationResponse
}