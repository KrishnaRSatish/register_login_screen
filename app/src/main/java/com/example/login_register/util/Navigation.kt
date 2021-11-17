package com.example.login_register.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.login_register.presentation.screens.login.LoginScreen
import com.example.login_register.presentation.screens.main_screen.MainScreen
import com.example.login_register.presentation.screens.register.RegisterScreen
import com.example.login_register.presentation.screens.splash.SplashScreen

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
        composable(
            route = Screen.MainScreen.route + "/{email}",
            arguments = listOf(
                navArgument("email"){
                    type =  NavType.StringType
                }
            )
        ){entry ->
            MainScreen( name= entry.arguments?.getString("email"),navController = navController)
        }

    }
}