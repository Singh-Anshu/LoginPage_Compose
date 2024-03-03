package com.example.loginpagecompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NormalTextComponent(textName: String) {

    Text(
        text = textName,
        modifier = Modifier.fillMaxWidth().heightIn(min =  80.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            fontStyle = FontStyle.Normal
        )
    )
}