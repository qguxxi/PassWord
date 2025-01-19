package com.synth.password.navigation

sealed class PassWordDestinations(val route: String) {
    data object Home : PassWordDestinations("home")
    data object SignIn : PassWordDestinations("signin")
    data object SignUp : PassWordDestinations("signup")
    data object Add : PassWordDestinations("add")
    data object Profile : PassWordDestinations("profile")
    data object Main : PassWordDestinations("main")
    data object Biometric : PassWordDestinations("biometric")
}