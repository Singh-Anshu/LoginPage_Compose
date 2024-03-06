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
import androidx.compose.material.icons.filled.Person
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
import com.example.loginpagecompose.components.CheckBoxComponent
import com.example.loginpagecompose.components.ClickableLoginTextCompose
import com.example.loginpagecompose.components.DividerComponent
import com.example.loginpagecompose.components.HeadingTextComponent
import com.example.loginpagecompose.components.LoginByGoogleAndFB
import com.example.loginpagecompose.components.MyTextField
import com.example.loginpagecompose.components.NormalTextComponent
import com.example.loginpagecompose.components.PassWordTextField
import com.example.loginpagecompose.navigation.PostOfficeAppRouter

@Composable
fun SignUpScreen() {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        val scrollSate  = rememberScrollState()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

        ) {

            Column(
                modifier = Modifier.weight(1f).
                verticalScroll(state = scrollSate), // This makes the column take up all available space
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                NormalTextComponent(stringResource(R.string.hello))
                // Spacer(Modifier.height(20.dp))
                HeadingTextComponent(stringResource(R.string.create_an_account))
                Spacer(Modifier.height(20.dp))
                MyTextField(stringResource(R.string.first_name), Icons.Default.Person)
                Spacer(Modifier.height(10.dp))
                MyTextField(stringResource(R.string.last_name), Icons.Default.Person)
                Spacer(Modifier.height(10.dp))
                MyTextField(stringResource(R.string.email), Icons.Default.Email)
                Spacer(Modifier.height(10.dp))
                PassWordTextField(stringResource(R.string.password), Icons.Default.Lock)
                CheckBoxComponent(value = stringResource(R.string.terms_conditions),
                    onTexSelected = {
                        PostOfficeAppRouter.navigateTo(Screen.TermsAndConditionsScreen)
                    })
                Spacer(Modifier.height(80.dp))
                ButtonComponent(value = stringResource(R.string.register))
                Spacer(Modifier.height(20.dp))
                DividerComponent()
                Spacer(Modifier.height(10.dp))
                LoginByGoogleAndFB()
               // Spacer(Modifier.height(60.dp))

            }

            // This view set at the bottom
            ClickableLoginTextCompose(tryingToLogin = true, onTexSelected = {
                PostOfficeAppRouter.navigateTo(Screen.LoginScreen)
            })
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreviewOfSignupScreen() {

    SignUpScreen()
}