package com.example.loginpagecompose.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.loginpagecompose.app.Screen

object PostOfficeAppRouter {
    var currentState: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination: Screen){
        currentState.value = destination
    }
}