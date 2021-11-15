package com.example.login_register.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.login_register.presentation.login.LoginScreen
import com.example.login_register.presentation.main_screen.MainScreen
import com.example.login_register.presentation.register.RegisterScreen
import com.example.login_register.presentation.splash.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route)
    {
        composable(
            Screen.SplashScreen.route
        ) {
            SplashScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController = navController)
        }
        composable(Screen.MainScreen.route){
            MainScreen(navController = navController)
        }

    }
}