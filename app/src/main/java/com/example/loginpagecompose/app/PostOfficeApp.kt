package com.example.loginpagecompose.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.loginpagecompose.navigation.PostOfficeAppRouter
import com.example.loginpagecompose.screens.SignUpScreen
import com.example.loginpagecompose.screens.TermsAndConditionsScreen

@Composable
fun PostOfficeApp(){

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = PostOfficeAppRouter.currentState, label = "") { currentState ->
            when(currentState.value){

                is Screen.SignUpScreen -> {
                    SignUpScreen()
                }

                is Screen.TermsAndConditionsScreen -> {
                    TermsAndConditionsScreen()
                }
            }

        }
    }
}