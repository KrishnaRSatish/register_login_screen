package com.example.login_register.presentation.main_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun MainScreen(
    name:String?,
    navController: NavController
){
    Column( modifier = Modifier
        .fillMaxWidth()) {
        Text(
            text = "Main Screen",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
        )
        Text(
            text = "Logged in as $name",
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h1,
        )
    }
}