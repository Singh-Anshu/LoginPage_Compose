package com.example.loginpagecompose.app

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

sealed class Screen {

    object SignUpScreen :Screen()
    object TermsAndConditionsScreen: Screen()

}

object PosOfficeAppRouter{

    var currentState: MutableState<Screen> = mutableStateOf(Screen.SignUpScreen)

    fun navigateTo(destination: Screen){
        currentState.value = destination
    }
}
