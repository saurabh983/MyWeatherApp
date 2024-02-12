package com.weather.myapp.ui.feature.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.weather.myapp.data.db.entities.WeatherHistory
import com.weather.myapp.data.location.LocationModel
import com.weather.myapp.data.request.CurrentWeatherRequest
import com.weather.myapp.data.response.CurrentLocationResponse
import com.weather.myapp.repository.DatabaseRepository
import com.weather.myapp.repository.NetworkRepository
import com.weather.myapp.resource.Status
import com.weather.myapp.resource.StringConstants
import com.weather.myapp.resource.extension.convertTimeMillisToFormattedString
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NetworkRepository, private val dbRepository: DatabaseRepository,
                                        private val _locationData: LiveData<LocationModel>
): ViewModel() {

    fun getLocationData() = _locationData

    var weatherResponseState = mutableStateOf(CurrentLocationResponse(null, null, null, null, null, null, null,null, null))

    var loading = mutableStateOf(false)

    var savedWeatherHistoryList = mutableStateListOf<CurrentLocationResponse>()

    var dataSaved = false

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentWeatherData(currentWeatherRequest: CurrentWeatherRequest){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repository.getCurrentWeather(currentWeatherRequest).collectLatest {
                    when(it.status){
                        Status.LOADING-> loading.value = true
                        Status.SUCCESS-> {
                            loading.value = false
                            weatherResponseState.value = it.data!!

                            if (!dataSaved) {
                                dataSaved = true
                                it.data.timeSaved = System.currentTimeMillis().convertTimeMillisToFormattedString(
                                    StringConstants.savedTimePattern, false)
                                val weatherHistory =
                                    WeatherHistory(
                                        Gson().toJson(it.data)
                                    )
                                dbRepository.insertHistoryData(weatherHistory = weatherHistory)
                            }
                        }
                        Status.ERROR-> {
                            loading.value = false
                        }
                    }
                }
            }
        }
    }

    fun getSavedWeatherHistory(){
        viewModelScope.launch{
            withContext(Dispatchers.IO){
                dbRepository.getHistoryList().collect{
                    savedWeatherHistoryList.clear()
                    savedWeatherHistoryList.addAll(it.map { it.getWeatherDetailsModel() })
                }
            }
        }
    }
}