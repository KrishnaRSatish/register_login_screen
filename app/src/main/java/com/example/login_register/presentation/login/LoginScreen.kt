package com.example.login_register.presentation.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import com.example.login_register.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {
    Box(modifier = Modifier
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
                text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.usernameText.value,
                onValueChange = {
                    viewModel.setUserNameText(it)
                },
                hint = stringResource(id = R.string.email_hint),
                //isError = viewModel.usernameText.value == "error"
                 error = viewModel.usernameError.value,

            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            StandardTextField(
                text = viewModel.passwordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                  /*  if( viewModel.passwordText.value=="error"){
                        viewModel.setPasswordError("Password Error")
                    }
                    else{
                        viewModel.setPasswordError("")
                    }*/
                },
                hint = stringResource(id = R.string.password_hint),
                error = viewModel.passwordError.value,
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPassword.value
            ) {
                viewModel.setShowPassword(it)
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route)
            },
            modifier = Modifier
                .align(Alignment.End)
            ) {
                Text(text = stringResource(id = R.string.login),
                color = MaterialTheme.colors.onPrimary)

            }
        }


        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_an_account_yet))
                append("")

               withStyle(style = SpanStyle(
                   color = MaterialTheme.colors.primary
               )
               ) {
                   append("   Sign Up")
                }
            } ,
             style = MaterialTheme.typography.body1,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navController.navigate(Screen.RegisterScreen.route)
                }

        )
    }
}