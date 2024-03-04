package com.example.loginpagecompose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpagecompose.R

@Composable
fun NormalTextComponent(textName: String) {

    Text(
        text = textName,
        modifier = Modifier.fillMaxWidth().heightIn(min = 40.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 24.sp,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
    }

@Composable
fun HeadingTextComponent(textName: String) {

    Text(
        text = textName,
        modifier = Modifier.fillMaxWidth().heightIn(),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFeild(labelValue: String, imageVector: ImageVector) {

    var textValue = remember { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        label = { Text(text = labelValue) },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(R.color.colorPrimary),
            focusedLabelColor = colorResource(R.color.colorPrimary),
            cursorColor = colorResource(R.color.colorPrimary),
            containerColor = colorResource(R.color.gainsboro)
        ),
        // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
        keyboardOptions = KeyboardOptions.Default,
        value = textValue.value,
        onValueChange = {it ->
            textValue.value = it
        },
        leadingIcon = {
            Icon(imageVector = imageVector , contentDescription ="Person")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassWordTextFeild(labelValue: String, imageVector: ImageVector) {

    var password = remember { mutableStateOf("") }

    var passwordVisible = remember { mutableStateOf(false) }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        label = { Text(text = labelValue) },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(R.color.colorPrimary),
            focusedLabelColor = colorResource(R.color.colorPrimary),
            cursorColor = colorResource(R.color.colorPrimary),
            containerColor = colorResource(R.color.gainsboro)
        ),
        // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        value = password.value,
        onValueChange = {it ->
            password.value = it
        },
        leadingIcon = {
            Icon(imageVector = imageVector , contentDescription ="Person")
        },

        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff

            }

            val description = if (passwordVisible.value) {
                stringResource(id =  R.string.hide_password)
            } else {
                stringResource(id =  R.string.show_password)
            }

            IconButton(onClick = {passwordVisible.value = !passwordVisible.value}){
                Icon(imageVector = iconImage, contentDescription  = description)
            }

        },
        visualTransformation = if(passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}
