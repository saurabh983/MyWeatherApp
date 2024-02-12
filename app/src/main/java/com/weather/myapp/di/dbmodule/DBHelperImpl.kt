package com.weather.myapp.di.dbmodule

import com.weather.myapp.data.db.dao.HistoryDao
import com.weather.myapp.data.db.dao.UsersDao
import com.weather.myapp.data.db.entities.Users
import com.weather.myapp.data.db.entities.WeatherHistory
import javax.inject.Inject

class DBHelperImpl @Inject constructor(private val usersDao: UsersDao, private val historyDao: HistoryDao): DBHelper {

    override suspend fun insertUserData(users: Users) {
        usersDao.insertUser(users)
    }

    override suspend fun getUserList(email: String)= usersDao.getUserList(email)
    override suspend fun insertHistory(weatherHistory: WeatherHistory) {
        historyDao.insertHistory(weatherHistory)
    }

    override suspend fun getHistoryList() = historyDao.getHistoryList()

    override suspend fun deleteAllData() = historyDao.deleteData()
}