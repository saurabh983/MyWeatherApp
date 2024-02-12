package com.weather.myapp.di.dbmodule

import com.weather.myapp.data.db.entities.Users
import com.weather.myapp.data.db.entities.WeatherHistory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class FakeDBHelper: DBHelper {

    val historyList = ArrayList<WeatherHistory>()

    val usersList = ArrayList<Users>()

    override suspend fun insertUserData(users: Users) {
        usersList.add(users)
    }

    override suspend fun getUserList(email: String): Flow<List<Users>> {
        return flowOf(usersList)
    }

    override suspend fun insertHistory(weatherHistory: WeatherHistory) {
        historyList.add(weatherHistory)
    }

    override suspend fun getHistoryList(): Flow<List<WeatherHistory>> {
        return flowOf(historyList)
    }

    override suspend fun deleteAllData() {
        historyList.clear()
    }
}