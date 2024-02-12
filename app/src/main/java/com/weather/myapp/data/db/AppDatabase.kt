package com.weather.myapp.data.db

import androidx.annotation.Keep
import androidx.room.Database
import androidx.room.RoomDatabase
import com.weather.myapp.data.db.dao.HistoryDao
import com.weather.myapp.data.db.dao.UsersDao
import com.weather.myapp.data.db.entities.Users
import com.weather.myapp.data.db.entities.WeatherHistory

@Keep
@Database(entities = [Users::class, WeatherHistory::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
    abstract fun historyDao(): HistoryDao
}