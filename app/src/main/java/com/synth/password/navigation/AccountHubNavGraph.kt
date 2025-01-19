package com.synth.password.navigation

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.synth.password.ui.screen.AddScreen
import com.synth.password.ui.screen.HomeScreen
import com.synth.password.ui.screen.MainScreen
import com.synth.password.ui.screen.ProfileScreen
import com.synth.password.ui.screen.SignInScreen
import com.synth.password.ui.screen.SignUpScreen
import com.synth.password.ViewModelFactory
import com.synth.password.data.AppDatabase
import com.synth.password.repository.UserRepository

@Composable
fun PassWordNavGraph(navController: NavHostController = rememberNavController()) {
    val context = LocalContext.current
    val appDatabase = AppDatabase.getInstance(context)
    val userDao = appDatabase.userDao()
    val viewModelFactory = ViewModelFactory(UserRepository(userDao), Application())
    NavHost(navController = navController, startDestination = PassWordDestinations.SignIn.route){
        composable(route = PassWordDestinations.Home.route) {
            HomeScreen()
        }
        composable(route = PassWordDestinations.SignUp.route) {
            SignUpScreen(viewModelFactory,navController)
        }
        composable(route = PassWordDestinations.SignIn.route) {
            SignInScreen(viewModelFactory,navController)
        }
        composable(route = PassWordDestinations.Add.route) {
            AddScreen()
        }
        composable(route = PassWordDestinations.Profile.route) {
            ProfileScreen()
        }
        composable(route = PassWordDestinations.Main.route) {
            MainScreen(navController)
        }
    }
}