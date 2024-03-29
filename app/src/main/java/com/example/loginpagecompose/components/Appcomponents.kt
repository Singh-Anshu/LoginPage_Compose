package com.example.loginpagecompose.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginpagecompose.R

@Composable
fun NormalTextComponent(textName: String) {

    Text(
        text = textName,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
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
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(),
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
fun MyTextField(labelValue: String, imageVector: ImageVector) {

    var textValue = rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        label = { Text(text = labelValue) },

        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(R.color.colorPrimary),
            focusedLabelColor = colorResource(R.color.colorPrimary),
            cursorColor = colorResource(R.color.colorPrimary),
            containerColor = colorResource(R.color.gainsboro),
        ),
        // keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Text,

        ),
        singleLine = true,
        maxLines = 1,
        value = textValue.value,
        onValueChange = { it ->
            textValue.value = it
        },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = "Person")
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PassWordTextField(labelValue: String, imageVector: ImageVector) {

    var password = rememberSaveable { mutableStateOf("") }

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
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        singleLine = true,
        maxLines = 1,
        value = password.value,
        onValueChange = {
            password.value = it
        },
        leadingIcon = {
            Icon(imageVector = imageVector, contentDescription = "Person")
        },

        trailingIcon = {
            val iconImage = if (passwordVisible.value) {
                Icons.Filled.Visibility
            } else {
                Icons.Filled.VisibilityOff

            }

            val description = if (passwordVisible.value) {
                stringResource(id = R.string.hide_password)
            } else {
                stringResource(id = R.string.show_password)
            }

            IconButton(onClick = { passwordVisible.value = !passwordVisible.value }) {
                Icon(imageVector = iconImage, contentDescription = description)
            }

        },
        visualTransformation = if (passwordVisible.value) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Composable
fun CheckBoxComponent(value: String, onTexSelected: (String) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        val checkedState = rememberSaveable {
            mutableStateOf(false)
        }

        Checkbox(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 4.dp) // Adjust the padding as needed
                .size(24.dp),
            colors = CheckboxDefaults.colors(colorResource(R.color.colorPrimary)),
            checked = checkedState.value,
            onCheckedChange = {
                checkedState.value = !checkedState.value
            })


        Spacer(Modifier.width(8.dp))

        ClickableTextCompose(value = value, onTexSelected)
    }
}

@Composable
fun ClickableTextCompose(value: String, onTexSelected: (String) -> Unit) {

    val initialText = "By continuing you accept our "
    val privacyPolicyText = " Privacy Policy "
    val andTexgt = " and "
    val termsAndConditionsText = " Term of Use"

    val annotatedString = buildAnnotatedString {

        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = privacyPolicyText, annotation = privacyPolicyText)
            append(privacyPolicyText)
        }
        append(andTexgt)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = termsAndConditionsText, annotation = termsAndConditionsText)
            append(termsAndConditionsText)
        }


    }
    ClickableText(text = annotatedString, onClick = { offset ->
        annotatedString.getStringAnnotations(offset, offset)
            .firstOrNull()?.also { span ->
                Log.d("ClickableTextCompose", "${span}")

                if (span.item == termsAndConditionsText || span.item == privacyPolicyText) {

                    onTexSelected(span.item)

                }
            }
    })

}

@Composable
fun ButtonComponent(value: String) {

    Button(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(48.dp),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(Color.Transparent)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(48.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        listOf(
                            colorResource(R.color.colorPrimary),
                            colorResource(R.color.colorSecondary)
                        )
                    ),
                    shape = RoundedCornerShape(50.dp)
                ),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = value,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

        }


    }
}

@Composable
fun DividerComponent() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(R.color.colorGray),
            thickness = 1.dp
        )

        Text(
            modifier = Modifier.padding(8.dp),
            text = "Or",
            fontSize = 18.sp,
            color = colorResource(R.color.colorText)
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            color = colorResource(R.color.colorGray),
            thickness = 1.dp
        )
    }
}

@Composable
fun LoginByGoogleAndFB() {

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {

        Box(
            modifier = Modifier
                .size(50.dp)
                .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp))
                .background(
                    color = Color.White,
                ),

            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.google), contentDescription = "Google"
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        Box(
            modifier = Modifier
                .size(50.dp)
                .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(4.dp))
                .background(
                    color = Color.White,
                ),

            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .width(24.dp)
                    .height(24.dp),
                painter = painterResource(id = R.drawable.facebook),
                contentDescription = "FaceBook"
            )
        }



    }
}

@Composable
fun ClickableLoginTextCompose(tryingToLogin: Boolean, onTexSelected: (String) -> Unit) {

    val initialText = if(tryingToLogin)"Already have an account? " else "Don't have an account yet? "
    val loginText =  if(tryingToLogin) " Login" else " Register"

    val annotatedString = buildAnnotatedString {

        append(initialText)
        withStyle(style = SpanStyle(color = colorResource(id = R.color.colorPrimary))) {
            pushStringAnnotation(tag = loginText, annotation = loginText)
            append(loginText)
        }
    }
    ClickableText(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center
        ),
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(offset, offset)
                .firstOrNull()?.also { span ->
                    Log.d("ClickableTextCompose", "${span}")

                    if (span.item == loginText) {
                        onTexSelected(span.item)
                    }
                }
        })

}

@Composable
fun UnderLinedTextComponent(textName: String) {

    Text(
        text = textName,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp),
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            fontStyle = FontStyle.Normal
        ),
        color = colorResource(id = R.color.colorText),
        textAlign = TextAlign.Center,
        textDecoration = TextDecoration.Underline
    )
}





