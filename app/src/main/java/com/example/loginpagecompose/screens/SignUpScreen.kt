package com.example.loginpagecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import com.example.loginpagecompose.components.HeadingTextComponent
import com.example.loginpagecompose.components.MyTextFeild
import com.example.loginpagecompose.components.NormalTextComponent
import com.example.loginpagecompose.components.PassWordTextFeild

@Composable
fun SignUpScreen() {

    Surface(
        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NormalTextComponent(stringResource(R.string.hello))
           // Spacer(Modifier.height(20.dp))
            HeadingTextComponent(stringResource(R.string.create_an_account))
            Spacer(Modifier.height(20.dp))
            MyTextFeild(stringResource(R.string.first_name), Icons.Default.Person)
            Spacer(Modifier.height(10.dp))
            MyTextFeild(stringResource(R.string.last_name), Icons.Default.Person)
            Spacer(Modifier.height(10.dp))
            MyTextFeild(stringResource(R.string.email), Icons.Default.Email)
            Spacer(Modifier.height(10.dp))
            PassWordTextFeild(stringResource(R.string.password), Icons.Default.Lock)
        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreviewOfSignupScreen() {

    SignUpScreen()
}