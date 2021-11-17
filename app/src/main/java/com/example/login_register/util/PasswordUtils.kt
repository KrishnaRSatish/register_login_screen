package com.example.login_register.util

import me.gosimple.nbvcxz.Nbvcxz
import timber.log.Timber

object PasswordUtils {
    var passwordLib = Nbvcxz()

     fun String.checkPasswordMinRequirement(): Boolean {
        val result = passwordLib.estimate(this)
         Timber.e("Ksat : Password bool: %s" ,result.isMinimumEntropyMet )
        return result.isMinimumEntropyMet
    }
}