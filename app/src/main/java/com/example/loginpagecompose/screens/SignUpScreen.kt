package com.example.loginpagecompose.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginpagecompose.R
import com.example.loginpagecompose.components.NormalTextComponent

@Composable
fun SignUpScreen() {

    Surface(
        color = Color.White,
        modifier = Modifier.fillMaxSize()
    ) {

        NormalTextComponent(stringResource(R.string.hello))
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreviewOfSignupScreen(){

    SignUpScreen()
}