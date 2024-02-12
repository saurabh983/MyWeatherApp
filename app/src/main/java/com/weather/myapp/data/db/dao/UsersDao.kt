package com.weather.myapp.data.db.dao

import androidx.annotation.Keep
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.weather.myapp.data.db.entities.Users
import kotlinx.coroutines.flow.Flow

@Keep
@Dao
interface UsersDao {
    @Insert
    fun insertUser(users: Users)

    @Query("select * from users where userName= :email")
    fun getUserList(email: String): Flow<List<Users>>
}