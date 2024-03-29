package com.weather.myapp.ui.feature.registration

import com.weather.myapp.CoroutineRule
import com.weather.myapp.repository.DatabaseRepository
import io.mockk.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class RegistrationViewModelTest {

    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var databaseRepository: DatabaseRepository

    // Use @Rule to apply the CoroutineRule
    @get:Rule
    val coroutineRule: CoroutineRule = CoroutineRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(coroutineRule.testDispatcher)
        databaseRepository = mockk()
        registrationViewModel = RegistrationViewModel(databaseRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `insertUser should call insertUserData in repository`() = runBlockingTest {
        // Arrange
        val testUser = com.weather.myapp.data.db.entities.Users(
            userName = "testUser",
            userPass = "password123"
        )

        // Act
        registrationViewModel.insertUser(testUser)

        // Assert
        coVerify { databaseRepository.insertUserData(testUser) }
    }

    @Test
    fun `deleteAllData should call deleteAllData in repository`() = runBlockingTest {
        // Act
        registrationViewModel.deleteAllData()

        // Assert
        coVerify { databaseRepository.deleteAllData() }
    }

}
