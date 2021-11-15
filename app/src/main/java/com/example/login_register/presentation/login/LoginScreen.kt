package com.example.login_register.presentation.login

import android.text.TextUtils
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
import com.example.login_register.util.Screen

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()

) {

    var isEmailValid by remember{
        mutableStateOf(false)
    }
    var isPasswordValid by remember{
        mutableStateOf(false)
    }
    val passwordMinLength = 5

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
                    isEmailValid = if(!viewModel.usernameText.value.isEmailValid()){
                        viewModel.setUserNameError("Enter Valid Email")
                        false
                    } else{
                        viewModel.setUserNameError("")
                        true
                    }
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
                    isPasswordValid = if( viewModel.passwordText.value.length<passwordMinLength){
                        viewModel.setPasswordError("Password too short")
                        false
                    } else{
                        viewModel.setPasswordError("")
                        true
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
            Button(onClick = {
                navController.navigate(Screen.MainScreen.route)
            },
            enabled= isEmailValid,
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

fun String.isEmailValid(): Boolean {
    return !TextUtils.isEmpty(this) && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}




