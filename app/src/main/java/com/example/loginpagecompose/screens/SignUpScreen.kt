package com.example.loginpagecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginpagecompose.R
import com.example.loginpagecompose.components.HeadingTextComponent
import com.example.loginpagecompose.components.NormalTextComponent

@Composable
fun SignUpScreen() {

    Surface(

        modifier = Modifier.fillMaxSize()
            .background(Color.White)
            .padding(20.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponent(stringResource(R.string.hello))
           // Spacer(Modifier.height(20.dp))
            HeadingTextComponent(stringResource(R.string.create_an_account))

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreviewOfSignupScreen() {

    SignUpScreen()
}