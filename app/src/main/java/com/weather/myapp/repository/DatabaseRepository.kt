package com.weather.myapp.repository

import com.weather.myapp.data.db.entities.Users
import com.weather.myapp.data.db.entities.WeatherHistory
import com.weather.myapp.di.dbmodule.DBHelper
import javax.inject.Inject

open class DatabaseRepository @Inject constructor(private val dbHelper: DBHelper) {
    open suspend fun insertUserData(users: Users) {
        dbHelper.insertUserData(users)
    }

    open suspend fun getUserList(email: String) = dbHelper.getUserList(email)

    open suspend fun insertHistoryData(weatherHistory: WeatherHistory) {
        dbHelper.insertHistory(weatherHistory)
    }

    open suspend fun getHistoryList() = dbHelper.getHistoryList()

    open suspend fun deleteAllData() = dbHelper.deleteAllData()
}