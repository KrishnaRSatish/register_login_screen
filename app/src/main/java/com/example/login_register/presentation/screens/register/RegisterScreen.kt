package com.example.login_register.presentation.screens.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.login_register.R
import com.example.login_register.presentation.components.StandardTextField
import com.example.login_register.presentation.ui.theme.SpaceLarge
import com.example.login_register.presentation.ui.theme.SpaceMedium
import com.example.login_register.presentation.viewmodels.RegisterViewModel
import com.example.login_register.util.Constants.MIN_PASSWORD_LENGTH
import com.example.login_register.util.Constants.MIN_USERNAME_LENGTH
import com.example.login_register.util.EmailUtils.isEmailValid
import com.example.login_register.util.Screen

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                start = SpaceLarge,
                end = SpaceLarge,
                top = SpaceLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = SpaceMedium)
                .align(Alignment.Center)
        ) {
            Text(
                text = stringResource(id = R.string.register),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.emailText.value,
                onValueChange = {
                    viewModel.setEmailText(it)
                    if (!viewModel.emailText.value.isEmailValid()) {
                        viewModel.setEmailError("Enter Valid Email")
                        viewModel.setIsEmailValid(false)
                    } else {
                        viewModel.setEmailError("")
                        viewModel.setIsEmailValid(true)
                    }
                },
                hint = stringResource(id = R.string.email),
                //isError = viewModel.usernameText.value == "error"
                error = viewModel.emailError.value,
                )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUserNameText(it)
                    if (viewModel.usernameText.value.length < MIN_USERNAME_LENGTH) {
                        viewModel.setUserNameError("Username too short")
                        viewModel.setIsUsernameValid(false)

                    } else {
                        viewModel.setUserNameError("")
                        viewModel.setIsUsernameValid(true)
                    }
                },
                hint = stringResource(id = R.string.username),
                //isError = viewModel.usernameText.value == "error"
                error = viewModel.usernameError.value,
                )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                    if (viewModel.passwordText.value.length < MIN_PASSWORD_LENGTH) {
                        viewModel.setPasswordError("Password too short")
                        viewModel.setIsPasswordValid(false)
                    } else {
                        viewModel.setPasswordError("")
                        viewModel.setIsPasswordValid(true)
                    }
                },
                hint = stringResource(id = R.string.password_hint),
                error = viewModel.passwordError.value,
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPassword.value
            ) {
                viewModel.setShowPassword(it)
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(
                onClick = {
                    navController.navigate(Screen.MainScreen.withArgs(viewModel.emailText.value))
                },
                enabled = viewModel.isEmailValid.value && viewModel.isPasswordValid.value && viewModel.isUserNameValid.value,
                modifier = Modifier
                    .align(Alignment.End)
            ) {
                Text(
                    text = stringResource(id = R.string.register),
                    color = MaterialTheme.colors.onPrimary
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append("")
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.primary
                    )
                ) {
                    append("  Sign in")
                }
            },
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

