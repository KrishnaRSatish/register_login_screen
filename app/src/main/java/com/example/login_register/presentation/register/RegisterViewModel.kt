package com.example.login_register.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor()  : ViewModel() {


    private val _usernameText = mutableStateOf("")
    val usernameText :State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText :State<String> = _passwordText

    private val _emailText = mutableStateOf("")
    val emailText :State<String> = _emailText

    private val _showPassword = mutableStateOf(false)
    val showPassword:State<Boolean> = _showPassword

    private val _usernameError = mutableStateOf("")
    val usernameError:State<String> = _usernameError

    private val _emailError = mutableStateOf("")
    val emailError:State<String> = _emailError

    private val _passwordError = mutableStateOf("")
    val passwordError:State<String> = _passwordError

    fun setUserNameText(username:String){
        _usernameText.value = username
    }

    fun setEmailText(email:String){
        _emailText.value = email
    }

    fun setPasswordText(password: String){
        _passwordText.value = password
    }

    fun setShowPassword(showPassword:Boolean){
        _showPassword.value=showPassword
    }

    fun setUserNameError(error:String){
       _usernameError.value = error
    }

    fun setEmailNameError(error:String){
        _emailError.value = error
    }

    fun setPasswordError(error:String){
        _passwordError.value = error
    }


}