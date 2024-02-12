package com.weather.myapp.ui.feature.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.weather.myapp.data.db.entities.Users
import com.weather.myapp.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(val databaseRepository: DatabaseRepository): ViewModel() {

    fun insertUser(users: Users){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                databaseRepository.insertUserData(users)
            }
        }

    }

    fun deleteAllData(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                databaseRepository.deleteAllData()
            }
        }
    }
}