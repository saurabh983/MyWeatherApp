package com.weather.myapp.ui.feature.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.MultiplePermissionsState
import com.weather.myapp.resource.StringConstants
import com.weather.myapp.resource.extension.get
import com.weather.myapp.resource.extension.myAppPreferences
import com.weather.myapp.ui.feature.home.HomeScreen
import com.weather.myapp.ui.feature.home.HomeViewModel
import com.weather.myapp.ui.feature.login.LoginScreen
import com.weather.myapp.ui.feature.login.LoginViewModel
import com.weather.myapp.ui.feature.registration.RegistrationScreen
import com.weather.myapp.ui.feature.registration.RegistrationViewModel


@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherAppNavigation(
    navController: NavHostController,
    locationPermissionState: MultiplePermissionsState, ) {
    val context = LocalContext.current
    NavHost(navController, startDestination = if (context.myAppPreferences.get(StringConstants.sessionConst, false)) StringConstants.homeRoute else StringConstants.loginRoute, modifier = Modifier.padding(16.dp),) {
        composable(route = StringConstants.loginRoute) {
            LoginScreen(navController, hiltViewModel<LoginViewModel>())
        }
        composable(route = StringConstants.registrationRoute) {
            RegistrationScreen(navController, hiltViewModel<RegistrationViewModel>())
        }

        composable(route = StringConstants.homeRoute) {
            if (locationPermissionState.allPermissionsGranted) {
                HomeScreen(hiltViewModel<HomeViewModel>(), navController)
            } else {
                locationPermissionState.launchMultiplePermissionRequest()
            }
        }
    }
}