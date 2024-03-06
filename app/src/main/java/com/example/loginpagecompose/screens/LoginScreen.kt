package com.example.loginpagecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpagecompose.R
import com.example.loginpagecompose.app.Screen
import com.example.loginpagecompose.components.ButtonComponent
import com.example.loginpagecompose.components.ClickableLoginTextCompose
import com.example.loginpagecompose.components.DividerComponent
import com.example.loginpagecompose.components.HeadingTextComponent
import com.example.loginpagecompose.components.LoginByGoogleAndFB
import com.example.loginpagecompose.components.MyTextField
import com.example.loginpagecompose.components.NormalTextComponent
import com.example.loginpagecompose.components.PassWordTextField
import com.example.loginpagecompose.components.UnderLinedTextComponent
import com.example.loginpagecompose.navigation.PostOfficeAppRouter
import com.example.loginpagecompose.navigation.SystemBackButtonHandler

@Composable
fun LoginScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        SystemBackButtonHandler {
            PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)
        }

        val scrollSate = rememberScrollState()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollSate),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {

            NormalTextComponent(stringResource(R.string.hello))
            HeadingTextComponent(stringResource(R.string.welcome_back))
            Spacer(Modifier.height(20.dp))
            MyTextField(stringResource(R.string.email), Icons.Default.Email)
            Spacer(Modifier.height(10.dp))
            PassWordTextField(stringResource(R.string.password), Icons.Default.Lock)
            Spacer(Modifier.height(20.dp))
            UnderLinedTextComponent(textName = stringResource(id = R.string.forgot_password))
            Spacer(Modifier.height(80.dp))
            ButtonComponent(value = stringResource(R.string.login))
            Spacer(Modifier.height(20.dp))
            DividerComponent()
            Spacer(Modifier.height(10.dp))
            LoginByGoogleAndFB()
            Spacer(Modifier.height(100.dp))
            ClickableLoginTextCompose(tryingToLogin = false, onTexSelected = {
                PostOfficeAppRouter.navigateTo(Screen.SignUpScreen)

            })


        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}