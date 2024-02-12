package com.weather.myapp.di.dbmodule

import com.weather.myapp.data.db.entities.Users
import com.weather.myapp.data.db.entities.WeatherHistory
import kotlinx.coroutines.flow.Flow

interface DBHelper {

    suspend fun insertUserData(users: Users)

    suspend fun getUserList(email: String): Flow<List<Users>>

    suspend fun insertHistory(weatherHistory: WeatherHistory)

    suspend fun getHistoryList(): Flow<List<WeatherHistory>>

    suspend fun deleteAllData()
}