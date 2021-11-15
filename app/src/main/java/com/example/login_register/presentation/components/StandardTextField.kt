package com.example.login_register.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import com.example.login_register.R

@Composable
fun StandardTextField(
    text: String = "",
    hint: String = "",
    maxLength:Int = 100,
    onValueChange: (String) -> Unit,
    error: String = "",
    keyboardType: KeyboardType = KeyboardType.Text,
    showPasswordToggle:Boolean = false,
    onPasswordToggleClick: (Boolean) -> Unit = {},
) {
    val isPasswordToggleDisplayed by remember {
        mutableStateOf(keyboardType == KeyboardType.Password)
    }
    Column(  modifier = Modifier
        .fillMaxWidth()) {
        TextField(
            value = text,
            onValueChange = {
                if(it.length<maxLength)
                {
                    onValueChange(it)
                } },
            placeholder = {
                Text(text = hint, style = MaterialTheme.typography.body1)
            },
            isError = error!="",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            visualTransformation = if (showPasswordToggle) {
                PasswordVisualTransformation()
            } else {
                VisualTransformation.None
            },
            singleLine = true,
            trailingIcon = {
                if (isPasswordToggleDisplayed) {
                    IconButton(onClick = {
                        onPasswordToggleClick(!showPasswordToggle)
                    }) {
                        Icon(
                            imageVector = if (showPasswordToggle) {
                                Icons.Filled.VisibilityOff
                            } else {
                                Icons.Filled.Visibility
                            },
                            contentDescription = if (showPasswordToggle) {
                                stringResource(id = R.string.password_visible_description)
                            } else {
                                stringResource(id = R.string.password_hidden_description)
                            }
                        )
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        if(error.isNotEmpty()) {
            Text(
                text = error,
                style = MaterialTheme.typography.body1,
                color = MaterialTheme.colors.error,
                modifier = Modifier
                    .fillMaxWidth(),
                textAlign = TextAlign.End
            )
        }
    }
}