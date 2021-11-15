package com.example.login_register.presentation.main_screen

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController

@Composable
fun MainScreen(
    navController: NavController
){
    Text(
        text = "Main Screen",
        color = MaterialTheme.colors.onBackground,
        style = MaterialTheme.typography.h1,
    )
}