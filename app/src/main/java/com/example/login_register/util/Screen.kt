package com.example.login_register.util

import android.annotation.SuppressLint

sealed class Screen(val route:String){
    @SuppressLint("CustomSplashScreen")
    object SplashScreen : Screen("splash_screen")
    object LoginScreen : Screen("login_screen")
    object RegisterScreen : Screen("register_screen")
    object MainScreen : Screen("main_screen")

    fun withArgs(vararg  args: String): String{
        return buildString{
            append(route)
            args.forEach{arg ->
                append("/$arg")
            }
        }
    }
}
